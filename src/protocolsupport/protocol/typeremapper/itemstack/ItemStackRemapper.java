package protocolsupport.protocol.typeremapper.itemstack;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.typeremapper.itemstack.complex.ItemStackComplexRemapperRegistry;
import protocolsupport.protocol.types.NetworkItemStack;
import protocolsupport.protocol.utils.i18n.I18NData;

public class ItemStackRemapper {

	public static int remapItemIdClientbound(ProtocolVersion version, int itemId) {
		itemId = LegacyItemType.REGISTRY.getTable(version).get(itemId);
		if (version.isAfterOrEq(ProtocolVersion.MINECRAFT_1_13)) {
			return FlatteningItemId.REGISTRY_TO_CLIENT.getTable(version).get(itemId);
		} else {
			return PreFlatteningItemIdData.getIdFromLegacyCombinedId(PreFlatteningItemIdData.getLegacyCombinedIdByModernId(itemId));
		}
	}

	public static NetworkItemStack remapToClient(ProtocolVersion version, String locale, NetworkItemStack itemstack) {
		itemstack = ItemStackComplexRemapperRegistry.remapToClient(version, locale, itemstack);
		itemstack.setTypeId(LegacyItemType.REGISTRY.getTable(version).get(itemstack.getTypeId()));
		if (version.isBefore(ProtocolVersion.MINECRAFT_1_13)) {
			int legacyCombinedId = PreFlatteningItemIdData.getLegacyCombinedIdByModernId(itemstack.getTypeId());
			itemstack.setTypeId(PreFlatteningItemIdData.getIdFromLegacyCombinedId(legacyCombinedId));
			if (!isComplexlyRemapped(itemstack)) {
				itemstack.setLegacyData(PreFlatteningItemIdData.getDataFromLegacyCombinedId(legacyCombinedId));
			}
		} else {
			itemstack.setTypeId(FlatteningItemId.REGISTRY_TO_CLIENT.getTable(version).get(itemstack.getTypeId()));
		}
		return itemstack;
	}

	public static NetworkItemStack remapFromClient(ProtocolVersion version, NetworkItemStack itemstack) {
		if (version.isBefore(ProtocolVersion.MINECRAFT_1_13)) {
			itemstack.setTypeId(PreFlatteningItemIdData.getModernIdByLegacyIdData(itemstack.getTypeId(), itemstack.getLegacyData()));
		} else {
			itemstack.setTypeId(FlatteningItemId.REGISTRY_FROM_CLIENT.getTable(version).get(itemstack.getTypeId()));
		}
		return ItemStackComplexRemapperRegistry.remapFromClient(version, I18NData.DEFAULT_LOCALE, itemstack);
	}

	public static boolean isComplexlyRemapped(NetworkItemStack itemstack) {
		return itemstack.getLegacyData() != NetworkItemStack.DEFAULT_LEGACY_DATA;
	}

}
