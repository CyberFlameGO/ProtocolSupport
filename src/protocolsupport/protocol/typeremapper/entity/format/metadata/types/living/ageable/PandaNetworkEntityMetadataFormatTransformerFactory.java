package protocolsupport.protocol.typeremapper.entity.format.metadata.types.living.ageable;

import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.types.base.AgeableNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class PandaNetworkEntityMetadataFormatTransformerFactory extends AgeableNetworkEntityMetadataFormatTransformerFactory {

	public static final PandaNetworkEntityMetadataFormatTransformerFactory INSTANCE = new PandaNetworkEntityMetadataFormatTransformerFactory();

	protected PandaNetworkEntityMetadataFormatTransformerFactory() {
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.BREED_TIMER, 17), ProtocolVersionsHelper.UP_1_17);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.BREED_TIMER, 16), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.BREED_TIMER, 15), ProtocolVersionsHelper.ALL_1_14);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.SNEEZE_TIMER, 18), ProtocolVersionsHelper.UP_1_17);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.SNEEZE_TIMER, 17), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.SNEEZE_TIMER, 16), ProtocolVersionsHelper.ALL_1_14);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.EAT_TIMER, 19), ProtocolVersionsHelper.UP_1_17);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.EAT_TIMER, 18), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.EAT_TIMER, 17), ProtocolVersionsHelper.ALL_1_14);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_MAIN, 20), ProtocolVersionsHelper.UP_1_17);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_MAIN, 19), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_MAIN, 18), ProtocolVersionsHelper.ALL_1_14);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_HIDDEN, 21), ProtocolVersionsHelper.UP_1_17);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_HIDDEN, 20), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.GENE_HIDDEN, 19), ProtocolVersionsHelper.ALL_1_14);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.PANDA_FLAGS, 22), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.PANDA_FLAGS, 21), ProtocolVersionsHelper.RANGE__1_15__1_16_4);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Panda.PANDA_FLAGS, 20), ProtocolVersionsHelper.ALL_1_14);
	}

}
