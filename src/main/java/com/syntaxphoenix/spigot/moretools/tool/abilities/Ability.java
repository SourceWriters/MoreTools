package com.syntaxphoenix.spigot.moretools.tool.abilities;

import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.tool.restriction.Restriction;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public abstract class Ability {
	
	public abstract void apply(Restriction restriction, Block start, Direction direction);
	
	public String getName() {
		return getClass().getSimpleName();
	}

}
