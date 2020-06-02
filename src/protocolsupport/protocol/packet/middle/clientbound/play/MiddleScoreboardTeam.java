package protocolsupport.protocol.packet.middle.clientbound.play;

import java.util.HashSet;
import java.util.Set;

import io.netty.buffer.ByteBuf;
import protocolsupport.api.chat.ChatAPI;
import protocolsupport.api.chat.components.BaseComponent;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.middle.CancelMiddlePacketException;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.utils.EnumConstantLookups.EnumConstantLookup;

public abstract class MiddleScoreboardTeam extends ClientBoundMiddlePacket {

	public MiddleScoreboardTeam(ConnectionImpl connection) {
		super(connection);
	}

	protected final Set<String> teams = new HashSet<>();

	protected String name;
	protected Mode mode;
	protected BaseComponent displayName;
	protected BaseComponent prefix;
	protected BaseComponent suffix;
	protected int friendlyFire;
	protected String nameTagVisibility;
	protected String collisionRule;
	protected int color;
	protected String[] players;

	@Override
	protected void readServerData(ByteBuf serverdata) {
		name = StringSerializer.readVarIntUTF8String(serverdata);
		mode = MiscSerializer.readByteEnum(serverdata, Mode.CONSTANT_LOOKUP);
		if ((mode == Mode.CREATE) || (mode == Mode.UPDATE)) {
			displayName = ChatAPI.fromJSON(StringSerializer.readVarIntUTF8String(serverdata), true);
			friendlyFire = serverdata.readUnsignedByte();
			nameTagVisibility = StringSerializer.readVarIntUTF8String(serverdata);
			collisionRule = StringSerializer.readVarIntUTF8String(serverdata);
			color = VarNumberSerializer.readVarInt(serverdata);
			prefix = ChatAPI.fromJSON(StringSerializer.readVarIntUTF8String(serverdata), true);
			suffix = ChatAPI.fromJSON(StringSerializer.readVarIntUTF8String(serverdata), true);
		}
		if ((mode == Mode.CREATE) || (mode == Mode.PLAYERS_ADD) || (mode == Mode.PLAYERS_REMOVE)) {
			players = ArraySerializer.readVarIntVarIntUTF8StringArray(serverdata);
		}

		switch (mode) {
			case CREATE: {
				if (!teams.add(name)) {
					throw CancelMiddlePacketException.INSTANCE;
				}
				break;
			}
			case REMOVE: {
				if (!teams.remove(name)) {
					throw CancelMiddlePacketException.INSTANCE;
				}
				break;
			}
			default: {
				if (!teams.contains(name)) {
					throw CancelMiddlePacketException.INSTANCE;
				}
				break;
			}
		}
	}

	protected static enum Mode {
		CREATE, REMOVE, UPDATE, PLAYERS_ADD, PLAYERS_REMOVE;
		public static final EnumConstantLookup<Mode> CONSTANT_LOOKUP = new EnumConstantLookup<>(Mode.class);
	}

}
