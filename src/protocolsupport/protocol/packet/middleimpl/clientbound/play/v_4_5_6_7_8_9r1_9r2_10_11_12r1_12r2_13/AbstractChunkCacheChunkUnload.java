package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13;

import protocolsupport.protocol.packet.middle.clientbound.play.MiddleChunkUnload;
import protocolsupport.protocol.storage.netcache.chunk.ChunkCache;

public abstract class AbstractChunkCacheChunkUnload extends MiddleChunkUnload {

	protected final ChunkCache chunkCache = cache.getChunkCache();

	public AbstractChunkCacheChunkUnload(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void handle() {
		chunkCache.remove(chunk);
	}

}
