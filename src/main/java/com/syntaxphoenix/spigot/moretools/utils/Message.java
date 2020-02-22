package com.syntaxphoenix.spigot.moretools.utils;

import net.md_5.bungee.api.ChatColor;

public class Message {
	
	public static String color(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}
	
}
