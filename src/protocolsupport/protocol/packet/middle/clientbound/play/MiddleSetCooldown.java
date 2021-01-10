package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public abstract class MiddleSetCooldown extends ClientBoundMiddlePacket {

	public MiddleSetCooldown(MiddlePacketInit init) {
		super(init);
	}

	protected int itemId;
	protected int cooldown;

	@Override
	protected void decode(ByteBuf serverdata) {
		itemId = VarNumberSerializer.readVarInt(serverdata);
		cooldown = VarNumberSerializer.readVarInt(serverdata);
	}

}
