package protocolsupport.protocol.types.nbt;

import protocolsupport.utils.reflection.ReflectionUtils;

public abstract class NBT {

	public abstract NBTType<?> getType();

	@Override
	public abstract boolean equals(Object other);

	@Override
	public abstract int hashCode();

	@Override
	public abstract NBT clone();

	@Override
	public String toString() {
		return ReflectionUtils.toStringAllFields(this);
	}

}
