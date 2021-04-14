package com.syntaxphoenix.spigot.moretools.utils.reflect;

import com.syntaxphoenix.syntaxapi.reflection.AbstractReflect;

public class Minecraft extends AbstractReflect {

	protected Minecraft(Class<?> owner) {
		super(owner);
	}

	protected Minecraft(String path) {
		super("net.minecraft.server." + Reflection.getVersion() + "." + path);
	}
	
}
