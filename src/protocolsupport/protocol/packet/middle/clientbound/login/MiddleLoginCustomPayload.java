package protocolsupport.protocol.packet.middle.clientbound.login;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public abstract class MiddleLoginCustomPayload extends ClientBoundMiddlePacket {

	public MiddleLoginCustomPayload(MiddlePacketInit init) {
		super(init);
	}

	protected int id;
	protected String tag;
	protected ByteBuf data;

	@Override
	protected void decode(ByteBuf serverdata) {
		id = VarNumberSerializer.readVarInt(serverdata);
		tag = StringSerializer.readVarIntUTF8String(serverdata);
		data = MiscSerializer.readAllBytesSlice(serverdata);
	}

	@Override
	protected void cleanup() {
		tag = null;
		data = null;
	}

}
