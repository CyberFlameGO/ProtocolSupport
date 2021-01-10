package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13_14r1_14r2_15_16r1_16r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleCraftRecipeRequest;
import protocolsupport.protocol.serializer.StringSerializer;

public class CraftRecipeRequest extends MiddleCraftRecipeRequest {

	public CraftRecipeRequest(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		windowId = clientdata.readUnsignedByte();
		recipeId = StringSerializer.readVarIntUTF8String(clientdata, Short.MAX_VALUE);
		all = clientdata.readBoolean();
	}

}
