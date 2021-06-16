package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public abstract class MiddleUpdateMap extends ClientBoundMiddlePacket {

	protected MiddleUpdateMap(MiddlePacketInit init) {
		super(init);
	}

	protected int id;
	protected int scale;
	protected boolean showIcons;
	protected boolean locked;
	protected Icon[] icons;
	protected int columns;
	protected int rows;
	protected int xstart;
	protected int zstart;
	protected byte[] colors;

	@Override
	protected void decode(ByteBuf serverdata) {
		id = VarNumberSerializer.readVarInt(serverdata);
		scale = serverdata.readUnsignedByte();
		locked = serverdata.readBoolean();
		showIcons = serverdata.readBoolean();
		if (showIcons) {
			icons = ArraySerializer.readVarIntTArray(
				serverdata, Icon.class,
				from -> new Icon(
					VarNumberSerializer.readVarInt(from),
					from.readUnsignedByte(),
					from.readUnsignedByte(),
					from.readByte(),
					from.readBoolean() ? StringSerializer.readVarIntUTF8String(serverdata) : null
				)
			);
		} else {
			icons = new Icon[0];
		}
		columns = serverdata.readUnsignedByte();
		if (columns > 0) {
			rows = serverdata.readUnsignedByte();
			xstart = serverdata.readUnsignedByte();
			zstart = serverdata.readUnsignedByte();
			colors = ArraySerializer.readVarIntByteArray(serverdata);
		}
	}

	public static class Icon {
		//TODO: enum for icon types
		public final int type;
		public final int x;
		public final int z;
		public final int direction;
		public final String displayName;
		public Icon(int type, int x, int z, int direction, String displayName) {
			this.type = type;
			this.x = x;
			this.z = z;
			this.direction = direction;
			this.displayName = displayName;
		}
	}

}
