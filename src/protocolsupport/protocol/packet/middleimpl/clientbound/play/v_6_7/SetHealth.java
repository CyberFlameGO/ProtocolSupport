package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_6_7;

import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleSetHealth;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleClientCommand;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.storage.netcache.ClientCache;

public class SetHealth extends MiddleSetHealth {

	protected final ClientCache clientCache = cache.getClientCache();

	public SetHealth(ConnectionImpl connection) {
		super(connection);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData sethealth = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_SET_HEALTH);
		sethealth.writeFloat(health);
		sethealth.writeShort(food);
		sethealth.writeFloat(saturation);
		codec.write(sethealth);

		if ((health <= 0) && !clientCache.isRespawnScreenEnabled()) {
			codec.readAndComplete(MiddleClientCommand.create(MiddleClientCommand.Command.REQUEST_RESPAWN));
		}
	}

}
