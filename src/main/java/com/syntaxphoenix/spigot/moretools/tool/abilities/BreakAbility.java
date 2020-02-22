package com.syntaxphoenix.spigot.moretools.tool.abilities;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.MoreTools;
import com.syntaxphoenix.spigot.moretools.tool.restriction.Restriction;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public abstract class BreakAbility extends Ability {
	
	public void apply(Restriction restrict, Block block, Direction direction) {
		Location[] locations = calculate(direction, block.getLocation());
		ArrayList<Block> breakable = new ArrayList<>();
		for(Location location : locations) {
			Block current = location.getBlock();
			if(current.getType().name().contains("AIR")) {
				continue;
			}
			if(restrict.isAllowed(current)) {
				breakable.add(current);
			}
		}
		Bukkit.getScheduler().runTask(MoreTools.getPlugin(MoreTools.class), () -> {
			for(Block destroy : breakable) {
				breakBlock(destroy);
			}
		});
	}
	
	public abstract Location[] calculate(Direction direction, Location start);

	public abstract void breakBlock(Block block);
	
}
