package com.syntaxphoenix.spigot.moretools.tool.restriction;

import org.bukkit.block.Block;

public class NoneRestricted extends Restriction {

	@Override
	public boolean isAllowed(Block block) {
		return true;
	}

}
