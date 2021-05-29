package protocolsupport.protocol.packet.middle.clientbound.status;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.types.pingresponse.PingResponse;

public abstract class MiddleServerInfo extends ClientBoundMiddlePacket {

	protected MiddleServerInfo(MiddlePacketInit init) {
		super(init);
	}

	protected PingResponse ping;

	@Override
	protected void decode(ByteBuf serverdata) {
		ping = PingResponse.fromJson(StringSerializer.readVarIntUTF8String(serverdata));
	}

}
