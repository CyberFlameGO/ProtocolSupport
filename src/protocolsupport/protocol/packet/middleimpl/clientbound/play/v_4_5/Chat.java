package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5;

import protocolsupport.api.chat.ChatAPI.MessagePosition;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleChat;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.storage.netcache.ClientCache;

public class Chat extends MiddleChat {

	protected final ClientCache clientCache = cache.getClientCache();

	public Chat(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		if (position == MessagePosition.HOTBAR) {
			return;
		}

		ClientBoundPacketData chat = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_CHAT);
		StringSerializer.writeShortUTF16BEString(chat, message.toLegacyText(clientCache.getLocale()));
		codec.writeClientbound(chat);
	}

}
