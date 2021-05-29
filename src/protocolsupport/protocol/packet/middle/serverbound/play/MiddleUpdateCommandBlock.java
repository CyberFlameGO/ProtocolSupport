package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.PositionSerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.types.Position;
import protocolsupport.protocol.utils.EnumConstantLookup;

public abstract class MiddleUpdateCommandBlock extends ServerBoundMiddlePacket {

	public static final int FLAGS_BIT_TRACK_OUTPUT = 0;
	public static final int FLAGS_BIT_CONDITIONAL = 1;
	public static final int FLAGS_BIT_AUTO = 2;

	protected MiddleUpdateCommandBlock(MiddlePacketInit init) {
		super(init);
	}

	protected final Position position = new Position(0, 0, 0);
	protected String command;
	protected Mode mode;
	protected int flags;

	@Override
	protected void write() {
		codec.writeServerbound(create(position, command, mode, flags));
	}

	public enum Mode {
		SEQUENCE, AUTO, REDSTONE;
		public static final EnumConstantLookup<Mode> CONSTANT_LOOKUP = new EnumConstantLookup<>(Mode.class);
	}

	public static ServerBoundPacketData create(Position position, String command, Mode mode, int flags) {
		ServerBoundPacketData creator = ServerBoundPacketData.create(PacketType.SERVERBOUND_PLAY_UPDATE_COMMAND_BLOCK);
		PositionSerializer.writePosition(creator, position);
		StringSerializer.writeVarIntUTF8String(creator, command);
		MiscSerializer.writeVarIntEnum(creator, mode);
		creator.writeByte(flags);
		return creator;
	}

}
