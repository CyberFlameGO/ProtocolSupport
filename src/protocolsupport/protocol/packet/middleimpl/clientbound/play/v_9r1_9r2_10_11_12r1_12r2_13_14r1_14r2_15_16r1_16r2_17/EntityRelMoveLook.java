package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17.AbstractLocationOffsetEntityRelMoveLook;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class EntityRelMoveLook extends AbstractLocationOffsetEntityRelMoveLook {

	public EntityRelMoveLook(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData entityrelmovelook = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_REL_MOVE_LOOK);
		VarNumberSerializer.writeVarInt(entityrelmovelook, entityId);
		entityrelmovelook.writeShort(relX);
		entityrelmovelook.writeShort(relY);
		entityrelmovelook.writeShort(relZ);
		entityrelmovelook.writeByte(yaw);
		entityrelmovelook.writeByte(pitch);
		entityrelmovelook.writeBoolean(onGround);
		codec.writeClientbound(entityrelmovelook);
	}

}
