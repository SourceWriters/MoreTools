package com.syntaxphoenix.spigot.moretools.tool.restriction;

import org.bukkit.block.Block;

public class BiRestriction extends Restriction {
	
	private Restriction rest1;
	private Restriction rest2;
	
	public BiRestriction(Restriction rest1, Restriction rest2) {
		this.rest1 = rest1;
		this.rest2 = rest2;
	}

	@Override
	public boolean isAllowed(Block block) {
		return rest1.isAllowed(block) && rest2.isAllowed(block);
	}
	
	public Restriction getFirst() {
		return rest1;
	}
	
	public Restriction getSecond() {
		return rest2;
	}

}
