package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13_14r1_14r2_15_16r1_16r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleUpdateCommandMinecart;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class UpdateCommandMinecart extends MiddleUpdateCommandMinecart {

	public UpdateCommandMinecart(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		entityId = VarNumberSerializer.readVarInt(clientdata);
		command = StringSerializer.readVarIntUTF8String(clientdata, Short.MAX_VALUE);
		trackOutput = clientdata.readBoolean();
	}

}
