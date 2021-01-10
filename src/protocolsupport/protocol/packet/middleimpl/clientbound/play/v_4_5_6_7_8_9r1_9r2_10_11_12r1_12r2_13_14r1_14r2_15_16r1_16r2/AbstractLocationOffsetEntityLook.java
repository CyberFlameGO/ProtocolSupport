package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityLook;
import protocolsupport.protocol.typeremapper.entity.LegacyNetworkEntityLocationOffset;
import protocolsupport.protocol.typeremapper.entity.LegacyNetworkEntityRegistry;
import protocolsupport.protocol.typeremapper.entity.LegacyNetworkEntityRegistry.LegacyNetworkEntityTable;

public abstract class AbstractLocationOffsetEntityLook extends MiddleEntityLook {

	public AbstractLocationOffsetEntityLook(MiddlePacketInit init) {
		super(init);
	}

	protected final LegacyNetworkEntityTable legacyEntityEntryTable = LegacyNetworkEntityRegistry.INSTANCE.getTable(version);
	protected final LegacyNetworkEntityLocationOffset entityOffset = LegacyNetworkEntityLocationOffset.get(version);

	@Override
	protected void handle() {
		super.handle();

		LegacyNetworkEntityLocationOffset.Offset offset = entityOffset.get(legacyEntityEntryTable.get(entity.getType()).getType());
		if (offset != null) {
			yaw += offset.getYaw();
			pitch += offset.getPitch();
		}
	}

}
