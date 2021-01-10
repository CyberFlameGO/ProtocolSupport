package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.PositionSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.types.ChunkCoord;
import protocolsupport.protocol.types.chunk.ChunkConstants;
import protocolsupport.utils.BitUtils;

public abstract class MiddleChunkLight extends ClientBoundMiddlePacket {

	public MiddleChunkLight(MiddlePacketInit init) {
		super(init);
	}

	protected ChunkCoord coord;
	protected boolean trustEdges;
	protected int setSkyLightMask;
	protected int setBlockLightMask;
	protected int emptySkyLightMask;
	protected int emptyBlockLightMask;
	protected final byte[][] skyLight = new byte[ChunkConstants.SECTION_COUNT_LIGHT][];
	protected final byte[][] blockLight = new byte[ChunkConstants.SECTION_COUNT_LIGHT][];

	@Override
	protected void decode(ByteBuf serverdata) {
		coord = PositionSerializer.readVarIntChunkCoord(serverdata);
		trustEdges = serverdata.readBoolean();

		setSkyLightMask = VarNumberSerializer.readVarInt(serverdata);
		setBlockLightMask = VarNumberSerializer.readVarInt(serverdata);
		emptySkyLightMask = VarNumberSerializer.readVarInt(serverdata);
		emptyBlockLightMask = VarNumberSerializer.readVarInt(serverdata);

		for (int sectionNumber = 0; sectionNumber < ChunkConstants.SECTION_COUNT_LIGHT; sectionNumber++) {
			skyLight[sectionNumber] = BitUtils.isIBitSet(setSkyLightMask, sectionNumber) ? ArraySerializer.readVarIntByteArray(serverdata) : null;
		}
		for (int sectionNumber = 0; sectionNumber < ChunkConstants.SECTION_COUNT_LIGHT; sectionNumber++) {
			blockLight[sectionNumber] = BitUtils.isIBitSet(setBlockLightMask, sectionNumber) ? ArraySerializer.readVarIntByteArray(serverdata) : null;
		}
	}

}
