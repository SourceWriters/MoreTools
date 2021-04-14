package com.syntaxphoenix.spigot.moretools.utils.reflect;

import com.syntaxphoenix.syntaxapi.reflection.AbstractReflectCache;

public class MinecraftCache extends AbstractReflectCache<Minecraft> {

	@Override
	protected Minecraft create(Class<?> clazz) {
		return new Minecraft(clazz);
	}

	@Override
	protected Minecraft create(String path) {
		return new Minecraft(path);
	}

}
