package com.syntaxphoenix.spigot.moretools.tool.restriction;

import org.bukkit.block.Block;

public abstract class Restriction {
	
	public static final Restriction NONE = new NoneRestricted();
	
	public abstract boolean isAllowed(Block block);
	
	public String getName() {
		return getClass().getSimpleName();
	}

}
