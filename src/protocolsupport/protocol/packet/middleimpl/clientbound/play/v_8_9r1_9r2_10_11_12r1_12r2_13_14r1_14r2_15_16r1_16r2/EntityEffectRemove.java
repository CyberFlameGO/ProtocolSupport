package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityEffectRemove;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class EntityEffectRemove extends MiddleEntityEffectRemove {

	public EntityEffectRemove(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData entityeffectremove = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_EFFECT_REMOVE);
		VarNumberSerializer.writeVarInt(entityeffectremove, entityId);
		entityeffectremove.writeByte(effectId);
		codec.writeClientbound(entityeffectremove);
	}

}
