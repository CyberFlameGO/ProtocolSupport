package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleAdvancementsTab;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;

public class AdvancementsTab extends MiddleAdvancementsTab {

	public AdvancementsTab(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData advanvementstab = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ADVANCEMENTS_TAB);
		if (identifier != null) {
			advanvementstab.writeBoolean(true);
			StringSerializer.writeVarIntUTF8String(advanvementstab, identifier);
		} else {
			advanvementstab.writeBoolean(false);
		}
		codec.writeClientbound(advanvementstab);
	}

}
