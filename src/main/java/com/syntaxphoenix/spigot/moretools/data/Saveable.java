package com.syntaxphoenix.spigot.moretools.data;

import com.syntaxphoenix.spigotlib.mcnbt.NbtBase;
import com.syntaxphoenix.spigotlib.mcnbt.NbtCompound;

public interface Saveable {
	
	public NbtBase asNbt();
	
	public default String getNbtPath() {
		return getClass().getSimpleName();
	}
	
	public default void save(NbtCompound save) {
		save.set(getNbtPath(), asNbt());
	}
	
	public default String asString() {
		return asNbt().asString();
	}
	
}
