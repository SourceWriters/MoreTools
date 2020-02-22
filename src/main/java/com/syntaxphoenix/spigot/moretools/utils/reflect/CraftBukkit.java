package com.syntaxphoenix.spigot.moretools.utils.reflect;

import com.syntaxphoenix.syntaxapi.reflections.AbstractReflect;

public class CraftBukkit extends AbstractReflect {

	public CraftBukkit(Class<?> owner) {
		super(owner);
	}

	public CraftBukkit(String path) {
		super("org.bukkit.craftbukkit." + Reflection.getVersion() + "." + path);
	}
	
}
