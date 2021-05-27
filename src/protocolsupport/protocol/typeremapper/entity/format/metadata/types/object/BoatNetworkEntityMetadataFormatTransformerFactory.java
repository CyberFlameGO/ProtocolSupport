package protocolsupport.protocol.typeremapper.entity.format.metadata.types.object;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNumberToIntTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.types.base.BaseNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class BoatNetworkEntityMetadataFormatTransformerFactory extends BaseNetworkEntityMetadataFormatTransformerFactory {

	public static final BoatNetworkEntityMetadataFormatTransformerFactory INSTANCE = new BoatNetworkEntityMetadataFormatTransformerFactory();

	protected BoatNetworkEntityMetadataFormatTransformerFactory() {
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.TIME_SINCE_LAST_HIT, 7), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.TIME_SINCE_LAST_HIT, 6), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.TIME_SINCE_LAST_HIT, 5), ProtocolVersionsHelper.ALL_1_9);
		add(new NetworkEntityMetadataObjectIndexValueNumberToIntTransformer(NetworkEntityMetadataObjectIndex.Boat.TIME_SINCE_LAST_HIT, 17), ProtocolVersionsHelper.DOWN_1_8);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.FORWARD_DIRECTION, 8), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.FORWARD_DIRECTION, 7), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.FORWARD_DIRECTION, 6), ProtocolVersionsHelper.ALL_1_9);
		add(new NetworkEntityMetadataObjectIndexValueNumberToIntTransformer(NetworkEntityMetadataObjectIndex.Boat.FORWARD_DIRECTION, 18), ProtocolVersionsHelper.DOWN_1_8);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.DAMAGE_TAKEN, 9), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.DAMAGE_TAKEN, 8), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.DAMAGE_TAKEN, 7), ProtocolVersionsHelper.ALL_1_9);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.DAMAGE_TAKEN, 19), ProtocolVersion.getAllBetween(ProtocolVersion.MINECRAFT_1_8, ProtocolVersion.MINECRAFT_1_6_1));
		add(new NetworkEntityMetadataObjectIndexValueNumberToIntTransformer(NetworkEntityMetadataObjectIndex.Boat.DAMAGE_TAKEN, 19), ProtocolVersionsHelper.DOWN_1_5_2);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.VARIANT, 10), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.VARIANT, 9), ProtocolVersionsHelper.RANGE__1_10__1_13_2);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.LEFT_PADDLE, 11), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.LEFT_PADDLE, 10), ProtocolVersionsHelper.RANGE__1_10__1_13_2);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.RIGHT_PADDLE, 12), ProtocolVersionsHelper.UP_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.RIGHT_PADDLE, 11), ProtocolVersionsHelper.RANGE__1_10__1_13_2);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Boat.SPLASH_TIMER, 13), ProtocolVersionsHelper.UP_1_13);
	}

}
