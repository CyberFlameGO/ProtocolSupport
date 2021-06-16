package protocolsupport;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import protocolsupport.commands.CommandHandler;
import protocolsupport.listeners.LocaleUseLoader;
import protocolsupport.listeners.PotionEffectAmplifierClamp;
import protocolsupport.listeners.ReloadCommandBlocker;
import protocolsupport.listeners.TabAPIHandler;
import protocolsupport.listeners.emulation.BlockPlaceSelfSoundEmulation;
import protocolsupport.listeners.emulation.DamageHurtEffectEmulation;
import protocolsupport.listeners.emulation.LeaveVehicleOnCrouchEmulation;
import protocolsupport.listeners.emulation.LevitationSlowFallingEmulation;
import protocolsupport.utils.ResourceUtils;
import protocolsupport.utils.Utils;
import protocolsupport.zplatform.ServerPlatform;

public class ProtocolSupport extends JavaPlugin {

	private static ProtocolSupport instance;

	public static ProtocolSupport getInstance() {
		return instance;
	}

	public ProtocolSupport() {
		instance = this;
		System.setProperty("java.awt.headless", "true");
	}

	private BuildInfo buildinfo;

	public BuildInfo getBuildInfo() {
		return buildinfo;
	}

	protected static final String supported_platform_version = "1.17";


	private boolean loaded = false;

	@Override
	public void onLoad() {
		try {
			buildinfo = new BuildInfo();
		} catch (Throwable t) {
			getLogger().severe("Unable to load buildinfo, make sure you built this version using Gradle");
			return;
		}
		if (ProtocolSupportFileLog.isEnabled()) {
			ProtocolSupportFileLog.logInfoMessage("Server version: " + Bukkit.getVersion());
			ProtocolSupportFileLog.logInfoMessage("ProtocolSupport version: " + buildinfo.toString());
		}
		try {
			ServerPlatform.detect();
		} catch (Throwable t) {
			BIG_ERROR_THAT_ANYONE_CAN_SEE("Unsupported platform or version " + Bukkit.getVersion());
			getLogger().log(Level.SEVERE, "Platform init failed", t);
			return;
		}
		getLogger().info(() -> MessageFormat.format("Detected {0} server implementation type", ServerPlatform.get().getIdentifier().getName()));
		if (!ServerPlatform.get().getMiscUtils().getVersionName().equals(supported_platform_version)) {
			BIG_ERROR_THAT_ANYONE_CAN_SEE("Unsupported server minecraft version " + ServerPlatform.get().getMiscUtils().getVersionName());
			return;
		}
		try {
			ResourceUtils.getAsBufferedReader("preload").lines().forEach(name -> {
				try {
					Class.forName(name);
				} catch (ClassNotFoundException e) {
					throw new IllegalArgumentException("Class is in preload list, but wasn't found", e);
				}
			});
			ServerPlatform.get().getInjector().onLoad();
		} catch (Throwable t) {
			getLogger().log(Level.SEVERE, "Error when loading, shutting down", t);
			Bukkit.shutdown();
			return;
		}
		loaded = true;
	}

	protected void BIG_ERROR_THAT_ANYONE_CAN_SEE(String message) {
		Logger logger = getLogger();
		logger.severe("╔══════════════════════════════════════════════════════════════════╗");
		logger.severe("║                               ERROR                               ");
		logger.severe("║   " + message                                                      );
		logger.severe("║                                                                   ");
		logger.severe("║   This version of plugin only supports                            ");
		logger.severe("║   server minecraft version " + supported_platform_version          );
		logger.severe("║   and following platforms:                                        ");
		logger.severe("║   - Spigot (https://www.spigotmc.org/)                            ");
		logger.severe("║   - Paper (https://papermc.io/)                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║                                                                   ");
		logger.severe("║       https://github.com/ProtocolSupport/ProtocolSupport/         ");
		logger.severe("╚══════════════════════════════════════════════════════════════════╝");
	}

	@Override
	public void onEnable() {
		if (!loaded) {
			return;
		}
		ServerPlatform.get().getInjector().onEnable();
		getCommand("protocolsupport").setExecutor(new CommandHandler());

		PluginManager pluginmanager = getServer().getPluginManager();
		pluginmanager.registerEvents(new TabAPIHandler(), this);
		pluginmanager.registerEvents(new ReloadCommandBlocker(), this);
		pluginmanager.registerEvents(new LocaleUseLoader(), this);
		pluginmanager.registerEvents(new PotionEffectAmplifierClamp(), this);
		pluginmanager.registerEvents(new BlockPlaceSelfSoundEmulation(), this);
		pluginmanager.registerEvents(new DamageHurtEffectEmulation(), this);
		pluginmanager.registerEvents(new LeaveVehicleOnCrouchEmulation(), this);
		new LevitationSlowFallingEmulation().runTaskTimer(this, 1, 1);
	}

	@Override
	public void onDisable() {
		Bukkit.shutdown();
		if (!loaded) {
			return;
		}
		ServerPlatform.get().getInjector().onDisable();
	}

	public static class BuildInfo {
		public final String buildtime;
		public final String buildhost;
		public final String buildnumber;
		public final String buildgit;
		public BuildInfo() throws IOException {
			Properties properties = new Properties();
			properties.load(ResourceUtils.getAsBufferedReader("buildinfo"));
			buildtime = properties.getProperty("buildtime");
			buildhost = properties.getProperty("buildhost");
			buildnumber = properties.getProperty("buildnumber");
			buildgit = properties.getProperty("buildgit");
		}
		@Override
		public String toString() {
			return Utils.toStringAllFields(this);
		}
	}


	public static Logger getStaticLogger() {
		ProtocolSupport instance = getInstance();
		return instance != null ? instance.getLogger() : Logger.getLogger("ProtocolSupport");
	}

	public static void logInfo(String message) {
		getStaticLogger().info(message);
	}

	public static void logWarning(String message) {
		getStaticLogger().warning(message);
	}

	public static void logErrorSevere(String message, Throwable t) {
		getStaticLogger().log(Level.SEVERE, message, t);
	}

	public static void logErrorWarning(String message, Throwable t) {
		getStaticLogger().log(Level.WARNING, message, t);
	}

}
