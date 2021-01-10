package protocolsupport.protocol.packet.middleimpl.serverbound.handshake.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.handshake.MiddleSetProtocol;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class SetProtocol extends MiddleSetProtocol {

	public SetProtocol(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		VarNumberSerializer.readVarInt(clientdata);
		hostname = StringSerializer.readVarIntUTF8String(clientdata, Short.MAX_VALUE);
		port = clientdata.readUnsignedShort();
		nextState = VarNumberSerializer.readVarInt(clientdata);
	}

}
