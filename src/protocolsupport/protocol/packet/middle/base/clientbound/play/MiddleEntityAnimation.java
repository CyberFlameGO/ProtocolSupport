package protocolsupport.protocol.packet.middle.base.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.codec.VarNumberCodec;
import protocolsupport.protocol.packet.middle.MiddlePacketCancelException;
import protocolsupport.protocol.packet.middle.base.clientbound.ClientBoundMiddlePacket;
import protocolsupport.utils.CollectionsUtils;
import protocolsupport.utils.CollectionsUtils.ArrayMap;

public abstract class MiddleEntityAnimation extends ClientBoundMiddlePacket {

	protected MiddleEntityAnimation(IMiddlePacketInit init) {
		super(init);
	}

	protected int entityId;
	protected Animation animation;

	@Override
	protected void decode(ByteBuf serverdata) {
		entityId = VarNumberCodec.readVarInt(serverdata);
		animation = Animation.BY_ID.get(serverdata.readUnsignedByte());

		if (animation == null) {
			throw MiddlePacketCancelException.INSTANCE;
		}
	}

	protected enum Animation {
		SWING_MAIN_HAND(0), WAKE_UP(2), SWING_OFF_HAND(3), CRIT(4), MAGIC_CRIT(5);
		public static final ArrayMap<Animation> BY_ID = CollectionsUtils.makeEnumMappingArrayMap(Animation.class, Animation::getId);
		protected int id;
		Animation(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
	}

}
