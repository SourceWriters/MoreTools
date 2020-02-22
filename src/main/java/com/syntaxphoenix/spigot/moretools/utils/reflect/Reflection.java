package com.syntaxphoenix.spigot.moretools.utils.reflect;

import org.bukkit.Bukkit;

public class Reflection {
	
	private static CraftBukkitCache craftBukkit;
	private static MinecraftCache minecraft;
	private static String version;
	
	public static CraftBukkitCache getCraftBukkit() {
		return craftBukkit == null ? (craftBukkit = new CraftBukkitCache()) : craftBukkit;
	}
	
	public static MinecraftCache getMinecraft() {
		return minecraft == null ? (minecraft = new MinecraftCache()) : minecraft;
	}
	
	protected static String getVersion() {
		if(version == null) {
			return version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		}
		return version;
	}
	
}
