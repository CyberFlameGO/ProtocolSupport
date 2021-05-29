package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;

public abstract class MiddleNameItem extends ServerBoundMiddlePacket {

	protected MiddleNameItem(MiddlePacketInit init) {
		super(init);
	}

	protected String name;

	@Override
	protected void write() {
		codec.writeServerbound(create(name));
	}

	public static ServerBoundPacketData create(String name) {
		ServerBoundPacketData serializer = ServerBoundPacketData.create(PacketType.SERVERBOUND_PLAY_NAME_ITEM);
		StringSerializer.writeVarIntUTF8String(serializer, name);
		return serializer;
	}

}
