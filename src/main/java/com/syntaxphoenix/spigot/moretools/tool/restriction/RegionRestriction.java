package com.syntaxphoenix.spigot.moretools.tool.restriction;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.utils.LocationTools;

public class RegionRestriction extends Restriction {
	
	private Location first;
	private Location second;
	private boolean blacklist;
	
	public RegionRestriction(Location first, Location second) {
		this(first, second, false);
	}
	
	public RegionRestriction(Location first, Location second, boolean blacklist) {
		setFirst(first);
		setSecond(second);
		asBlacklist(blacklist);
	}

	/*
	 * 
	 * 
	 * 
	 */
	
	@Override
	public boolean isAllowed(Block block) {
		boolean out = isInRegion(block.getLocation());
		return isBlacklist() ? !out : out;
	}
	
	public boolean isInRegion(Location location) {
		return LocationTools.isBetween(location, getFirst(), getSecond());
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public boolean isBlacklist() {
		return blacklist;
	}
	
	public void asBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	public Location getFirst() {
		return first;
	}

	public void setFirst(Location first) {
		this.first = first;
	}

	public Location getSecond() {
		return second;
	}

	public void setSecond(Location second) {
		this.second = second;
	}

}
