package protocolsupport.protocol.typeremapper.itemstack.format.to;

import java.util.UUID;

import protocolsupport.protocol.typeremapper.itemstack.format.ItemStackNBTLegacyFormatOperator;
import protocolsupport.protocol.typeremapper.legacy.LegacyEntityAttribute;
import protocolsupport.protocol.types.NetworkItemStack;
import protocolsupport.protocol.types.nbt.NBTCompound;
import protocolsupport.protocol.types.nbt.NBTIntArray;
import protocolsupport.protocol.types.nbt.NBTList;
import protocolsupport.protocol.types.nbt.NBTLong;
import protocolsupport.protocol.types.nbt.NBTString;
import protocolsupport.protocol.utils.CommonNBT;

public class ItemStackLegacyFormatOperatorAttributesToLegacy extends ItemStackNBTLegacyFormatOperator {

	public static final String LEGACY_ATTRIBUTE_UUID_MOST = "UUIDMost";
	public static final String LEGACY_ATTRIBUTE_UUID_LEAST = "UUIDLeast";

	@Override
	public NBTCompound apply(String locale, NetworkItemStack itemstack, NBTCompound tag) {
		NBTList<NBTCompound> attributesTag = tag.getCompoundListTagOrNull(CommonNBT.ATTRIBUTES);
		if (attributesTag != null) {
			for (NBTCompound attributeTag : attributesTag.getTags()) {
				NBTString attributeIdTag = attributeTag.getStringTagOrNull(CommonNBT.ATTRIBUTE_ID);
				if (attributeIdTag != null) {
					attributeTag.setTag(CommonNBT.ATTRIBUTE_ID, new NBTString(LegacyEntityAttribute.getLegacyId(attributeIdTag.getValue())));
				}
				NBTIntArray uuidTag = attributeTag.getTagOfTypeOrNull(CommonNBT.ATTRIBUTE_UUID, NBTIntArray.class);
				if (uuidTag != null) {
					UUID uuid = CommonNBT.deserializeUUID(uuidTag);
					attributeTag.setTag(LEGACY_ATTRIBUTE_UUID_MOST, new NBTLong(uuid.getMostSignificantBits()));
					attributeTag.setTag(LEGACY_ATTRIBUTE_UUID_LEAST, new NBTLong(uuid.getMostSignificantBits()));
				}
			}
		}
		return tag;
	}

}
