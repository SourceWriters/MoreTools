package com.syntaxphoenix.spigot.moretools.tool.abilities;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public class NormalBreak extends BreakAbility {

	@Override
	public Location[] calculate(Direction direction, Location start) {
		return new Location[] {start};
	}

	@Override
	public void breakBlock(Block block) {
		block.breakNaturally();
	}

}
