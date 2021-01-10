package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.AbstractChunkCacheChangeDimension;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.typeremapper.legacy.LegacyDimension;
import protocolsupport.protocol.types.Difficulty;

public class ChangeDimension extends AbstractChunkCacheChangeDimension {

	public ChangeDimension(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeChangeDimension(int dimensionId) {
		ClientBoundPacketData changedimension = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_RESPAWN);
		changedimension.writeInt(dimensionId);
		MiscSerializer.writeByteEnum(changedimension, Difficulty.HARD);
		changedimension.writeByte(gamemodeCurrent.getId());
		StringSerializer.writeVarIntUTF8String(changedimension, LegacyDimension.getWorldType(worldFlat));
		codec.writeClientbound(changedimension);
	}

}
