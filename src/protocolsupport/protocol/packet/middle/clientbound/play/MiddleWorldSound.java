package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.types.SoundCategory;

public abstract class MiddleWorldSound extends ClientBoundMiddlePacket {

	protected MiddleWorldSound(MiddlePacketInit init) {
		super(init);
	}

	protected int id;
	protected SoundCategory category;
	protected int x;
	protected int y;
	protected int z;
	protected float volume;
	protected float pitch;

	@Override
	protected void decode(ByteBuf serverdata) {
		id = VarNumberSerializer.readVarInt(serverdata);
		category = MiscSerializer.readVarIntEnum(serverdata, SoundCategory.CONSTANT_LOOKUP);
		x = serverdata.readInt();
		y = serverdata.readInt();
		z = serverdata.readInt();
		volume = serverdata.readFloat();
		pitch = serverdata.readFloat();
	}

}
