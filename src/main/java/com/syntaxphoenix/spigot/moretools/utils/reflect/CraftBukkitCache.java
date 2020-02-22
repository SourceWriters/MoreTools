package com.syntaxphoenix.spigot.moretools.utils.reflect;

import com.syntaxphoenix.syntaxapi.reflections.AbstractReflectCache;

public class CraftBukkitCache extends AbstractReflectCache<CraftBukkit> {

	@Override
	protected CraftBukkit create(Class<?> clazz) {
		return new CraftBukkit(clazz);
	}

	@Override
	protected CraftBukkit create(String path) {
		return new CraftBukkit(path);
	}
	
}
