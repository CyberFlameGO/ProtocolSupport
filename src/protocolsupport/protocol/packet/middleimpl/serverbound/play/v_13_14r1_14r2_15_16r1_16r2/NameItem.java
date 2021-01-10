package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13_14r1_14r2_15_16r1_16r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleNameItem;
import protocolsupport.protocol.serializer.StringSerializer;

public class NameItem extends MiddleNameItem {

	public NameItem(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		name = StringSerializer.readVarIntUTF8String(clientdata, Short.MAX_VALUE);
	}

}
