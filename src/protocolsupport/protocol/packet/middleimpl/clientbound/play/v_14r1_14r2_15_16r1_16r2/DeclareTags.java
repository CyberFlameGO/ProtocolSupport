package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13_14r1_14r2_15_16r1_16r2.AbstractDeclareTags;

public class DeclareTags extends AbstractDeclareTags {

	public DeclareTags(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData declaretags = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_DECLARE_TAGS);
		writeBlocksTags(declaretags, blocks);
		writeItemsTags(declaretags, items);
		writeTags(declaretags, fluids);
		writeTags(declaretags, entities);
		codec.writeClientbound(declaretags);
	}

}
