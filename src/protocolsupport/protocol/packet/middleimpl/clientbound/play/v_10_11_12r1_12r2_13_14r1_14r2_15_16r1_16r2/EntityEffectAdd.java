package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityEffectAdd;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class EntityEffectAdd extends MiddleEntityEffectAdd {

	public EntityEffectAdd(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData effectadd = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_EFFECT_ADD);
		VarNumberSerializer.writeVarInt(effectadd, entityId);
		effectadd.writeByte(effectId);
		effectadd.writeByte(amplifier);
		VarNumberSerializer.writeVarInt(effectadd, duration);
		effectadd.writeByte(flags);
		codec.writeClientbound(effectadd);
	}

}
