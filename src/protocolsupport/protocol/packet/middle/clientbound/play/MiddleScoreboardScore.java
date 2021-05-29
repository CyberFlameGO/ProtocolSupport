package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public abstract class MiddleScoreboardScore extends ClientBoundMiddlePacket {

	protected MiddleScoreboardScore(MiddlePacketInit init) {
		super(init);
	}

	protected String name;
	protected int mode;
	protected String objectiveName;
	protected int value;

	@Override
	protected void decode(ByteBuf serverdata) {
		name = StringSerializer.readVarIntUTF8String(serverdata);
		mode = serverdata.readUnsignedByte();
		objectiveName = StringSerializer.readVarIntUTF8String(serverdata);
		if (mode != 1) {
			value = VarNumberSerializer.readVarInt(serverdata);
		}
	}

}
