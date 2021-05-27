package protocolsupport.protocol.typeremapper.entity.format.metadata.object.value;

import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObject;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectBoolean;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectByte;

public class NetworkEntityMetadataObjectIndexValueBooleanToByteTransformer extends NetworkEntityMetadataObjectIndexValueTransformer<NetworkEntityMetadataObjectBoolean> {

	public NetworkEntityMetadataObjectIndexValueBooleanToByteTransformer(NetworkEntityMetadataObjectIndex<NetworkEntityMetadataObjectBoolean> fromIndex, int toIndex) {
		super(fromIndex, toIndex);
	}

	@Override
	public NetworkEntityMetadataObject<?> transformValue(NetworkEntityMetadataObjectBoolean object) {
		return new NetworkEntityMetadataObjectByte((byte) (object.getValue() ? 1 : 0));
	}

}
