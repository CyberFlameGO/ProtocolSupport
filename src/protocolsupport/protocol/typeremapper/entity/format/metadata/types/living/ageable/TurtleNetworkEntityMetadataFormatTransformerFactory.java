package protocolsupport.protocol.typeremapper.entity.format.metadata.types.living.ageable;

import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.types.base.AgeableNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class TurtleNetworkEntityMetadataFormatTransformerFactory extends AgeableNetworkEntityMetadataFormatTransformerFactory {

	public static final TurtleNetworkEntityMetadataFormatTransformerFactory INSTANCE = new TurtleNetworkEntityMetadataFormatTransformerFactory();

	protected TurtleNetworkEntityMetadataFormatTransformerFactory() {
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HOME_POS, 16), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HOME_POS, 15), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HOME_POS, 13), ProtocolVersionsHelper.ALL_1_13);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HAS_EGG, 17), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HAS_EGG, 16), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.HAS_EGG, 14), ProtocolVersionsHelper.ALL_1_13);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.LAYING_EGG, 18), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.LAYING_EGG, 17), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.LAYING_EGG, 15), ProtocolVersionsHelper.ALL_1_13);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVEL_POS, 19), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVEL_POS, 18), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVEL_POS, 16), ProtocolVersionsHelper.ALL_1_13);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.GOING_HOME, 20), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.GOING_HOME, 19), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.GOING_HOME, 17), ProtocolVersionsHelper.ALL_1_13);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVELING, 21), ProtocolVersionsHelper.UP_1_15);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVELING, 20), ProtocolVersionsHelper.ALL_1_14);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Turtle.TRAVELING, 18), ProtocolVersionsHelper.ALL_1_13);
	}

}
