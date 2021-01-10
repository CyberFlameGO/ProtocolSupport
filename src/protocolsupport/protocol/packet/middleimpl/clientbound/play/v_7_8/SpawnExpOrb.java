package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleSpawnExpOrb;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class SpawnExpOrb extends MiddleSpawnExpOrb {

	public SpawnExpOrb(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData spawnexporb = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_SPAWN_EXP_ORB);
		VarNumberSerializer.writeVarInt(spawnexporb, entity.getId());
		spawnexporb.writeInt((int) (x * 32));
		spawnexporb.writeInt((int) (y * 32));
		spawnexporb.writeInt((int) (z * 32));
		spawnexporb.writeShort(count);
		codec.writeClientbound(spawnexporb);
	}

}
