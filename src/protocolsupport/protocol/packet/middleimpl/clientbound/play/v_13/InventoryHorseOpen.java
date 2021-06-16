package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13;

import protocolsupport.api.chat.components.TextComponent;
import protocolsupport.protocol.packet.ClientBoundPacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleInventoryHorseOpen;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.chat.ChatSerializer;
import protocolsupport.protocol.utils.i18n.I18NData;

public class InventoryHorseOpen extends MiddleInventoryHorseOpen {

	public InventoryHorseOpen(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData inventoryopen = ClientBoundPacketData.create(ClientBoundPacketType.PLAY_WINDOW_OPEN);
		InventoryOpen.writeData(inventoryopen, windowId, "EntityHorse", ChatSerializer.serialize(version, I18NData.DEFAULT_LOCALE, new TextComponent("Horse")), slots);
		inventoryopen.writeInt(entityId);
		codec.writeClientbound(inventoryopen);
	}

}
