package com.syntaxphoenix.spigot.moretools.utils.reflect;

public class Reflection {
	
	private static CraftBukkit craftBukkit;
	private static Minecraft minecraft;
	
	public static CraftBukkit getCB() {
		return craftBukkit == null ? (craftBukkit = new CraftBukkit()) : craftBukkit;
	}
	
	public static Minecraft getNMS() {
		return minecraft == null ? (minecraft = new Minecraft()) : minecraft;
	}

}
