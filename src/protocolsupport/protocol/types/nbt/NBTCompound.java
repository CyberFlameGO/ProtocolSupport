package protocolsupport.protocol.types.nbt;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NBTCompound extends NBT {

	@Override
	public NBTType<NBTCompound> getType() {
		return NBTType.COMPOUND;
	}

	protected final Map<String, NBT> tags = new LinkedHashMap<>();

	public NBTCompound() {
	}

	public NBTCompound(Map<String, NBT> tags) {
		for (Map.Entry<String, NBT> entry : tags.entrySet()) {
			this.tags.put(entry.getKey(), entry.getValue().clone());
		}
	}

	public boolean isEmpty() {
		return tags.isEmpty();
	}

	public Set<String> getTagNames() {
		return Collections.unmodifiableSet(tags.keySet());
	}

	public Map<String, NBT> getTags() {
		return Collections.unmodifiableMap(tags);
	}

	public NBT getTagOrThrow(String key) {
		NBT tag = getTagOrNull(key);
		if (tag == null) {
			throw new IllegalStateException(MessageFormat.format("NBT {0} does not exist", key));
		}
		return tag;
	}

	public NBT getTagOrNull(String key) {
		return tags.get(key);
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> T getTagOfTypeOrThrow(String key, Class<T> type) {
		NBT tag = getTagOrThrow(key);
		if (type.isInstance(tag)) {
			return (T) tag;
		} else {
			throw new IllegalStateException(MessageFormat.format("NBT {0} has unexpected type, expected {1}, but got {2}", key, type, tag.getClass()));
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> T getTagOfTypeOrNull(String key, Class<T> type) {
		NBT tag = getTagOrNull(key);
		if (type.isInstance(tag)) {
			return (T) tag;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> NBTList<T> getTagListOfTypeOrThrow(String key, Class<T> type) {
		NBTList<? extends NBT> list = getTagOfTypeOrThrow(key, NBTList.class);
		if (!type.isAssignableFrom(list.getTagsType().getNBTClass())) {
			throw new IllegalStateException(MessageFormat.format("NBTList {0} tags type has unexpected type, expected {1}, but got {2}", key, type, list.getTagsType().getNBTClass()));
		}
		return (NBTList<T>) list;
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> NBTList<T> getTagListOfTypeOrNull(String key, Class<T> type) {
		NBTList<? extends NBT> list = getTagOfTypeOrNull(key, NBTList.class);
		if ((list != null) && type.isAssignableFrom(list.getTagsType().getNBTClass())) {
			return (NBTList<T>) list;
		}
		return null;
	}

	public NBTCompound getCompoundTagOrThrow(String key) {
		return getTagOfTypeOrThrow(key, NBTCompound.class);
	}

	public NBTCompound getCompoundTagOrNull(String key) {
		return getTagOfTypeOrNull(key, NBTCompound.class);
	}

	public NBTNumber getNumberTagOrThrow(String key) {
		return getTagOfTypeOrThrow(key, NBTNumber.class);
	}

	public NBTNumber getNumberTagOrNull(String key) {
		return getTagOfTypeOrNull(key, NBTNumber.class);
	}

	public NBTString getStringTagOrThrow(String key) {
		return getTagOfTypeOrThrow(key, NBTString.class);
	}

	public NBTString getStringTagOrNull(String key) {
		return getTagOfTypeOrNull(key, NBTString.class);
	}

	public NBTList<NBTCompound> getCompoundListTagOrThrow(String key) {
		return getTagListOfTypeOrThrow(key, NBTCompound.class);
	}

	public NBTList<NBTCompound> getCompoundListTagOrNull(String key) {
		return getTagListOfTypeOrNull(key, NBTCompound.class);
	}

	public NBTList<NBTNumber> getNumberTagListTagOrThrow(String key) {
		return getTagListOfTypeOrThrow(key, NBTNumber.class);
	}

	public NBTList<NBTNumber> getNumberListTagOrNull(String key) {
		return getTagListOfTypeOrNull(key, NBTNumber.class);
	}

	public NBTList<NBTString> getStringListTagOrThrow(String key) {
		return getTagListOfTypeOrThrow(key, NBTString.class);
	}

	public NBTList<NBTString> getStringListTagOrNull(String key) {
		return getTagListOfTypeOrNull(key, NBTString.class);
	}

	public String getStringTagValueOrThrow(String key) {
		return getStringTagOrThrow(key).getValue();
	}

	public String getStringTagValueOrNull(String key) {
		NBT tag = getTagOrNull(key);
		if (NBTString.class.isInstance(tag)) {
			return ((NBTString) tag).getValue();
		}
		return null;
	}

	public String getStringTagValueOrDefault(String key, String defaultValue) {
		NBT tag = getTagOrNull(key);
		if (NBTString.class.isInstance(tag)) {
			return ((NBTString) tag).getValue();
		}
		return defaultValue;
	}

	public NBT removeTag(String key) {
		return tags.remove(key);
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> T removeTagAndReturnIfType(String key, Class<T> type) {
		NBT tag = removeTag(key);
		if (type.isInstance(tag)) {
			return (T) tag;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends NBT> NBTList<T> removeTagAndReturnIfListType(String key, Class<T> type) {
		NBTList<?> list = removeTagAndReturnIfType(key, NBTList.class);
		if ((list != null) && type.isAssignableFrom(list.getTagsType().getNBTClass())) {
			return (NBTList<T>) list;
		}
		return null;
	}

	public void setTag(String key, NBT tag) {
		if (tag != null) {
			tags.put(key, tag);
		} else {
			tags.remove(key);
		}
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof NBTCompound) && ((NBTCompound) other).tags.equals(tags);
	}

	@Override
	public int hashCode() {
		return tags.hashCode();
	}

	@Override
	public NBTCompound clone() {
		return new NBTCompound(tags);
	}

}
