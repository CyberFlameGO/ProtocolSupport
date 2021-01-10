package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;

public abstract class MiddleChat extends ServerBoundMiddlePacket {

	public MiddleChat(MiddlePacketInit init) {
		super(init);
	}

	protected String message;

	@Override
	protected void write() {
		codec.writeServerbound(create(message));
	}

	public static ServerBoundPacketData create(String message) {
		ServerBoundPacketData creator = ServerBoundPacketData.create(PacketType.SERVERBOUND_PLAY_CHAT);
		StringSerializer.writeVarIntUTF8String(creator, message);
		return creator;
	}

}
