package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.codec.VarNumberCodec;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleKeepAlive;
import protocolsupport.protocol.storage.netcache.KeepAliveCache;

public class KeepAlive extends MiddleKeepAlive {

	protected final KeepAliveCache keepaliveCache = cache.getKeepAliveCache();

	public KeepAlive(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void read(ByteBuf clientdata) {
		if (version.isBeforeOrEq(ProtocolVersion.MINECRAFT_1_12_1)) {
			keepAliveId = VarNumberCodec.readVarInt(clientdata);
		} else {
			keepAliveId = clientdata.readLong();
		}
		keepAliveId = keepaliveCache.tryConfirmKeepAlive((int) keepAliveId);
	}

}
