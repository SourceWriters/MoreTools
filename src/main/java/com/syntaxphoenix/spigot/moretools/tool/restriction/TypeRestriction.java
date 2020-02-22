package com.syntaxphoenix.spigot.moretools.tool.restriction;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class TypeRestriction extends Restriction {
	
	private List<Material> types;
	private boolean blacklist;
	
	public TypeRestriction(Material... typeArray) {
		this(false, typeArray);
	}
	
	public TypeRestriction(List<Material> types) {
		this(false, types);
	}
	
	public TypeRestriction(boolean blacklist, Material... typeArray) {
		setTypes(typeArray);
		asBlacklist(blacklist);
	}
	
	public TypeRestriction(boolean blacklist, List<Material> types) {
		setTypes(types);
		asBlacklist(blacklist);
	}

	/*
	 * 
	 * 
	 * 
	 */

	@Override
	public boolean isAllowed(Block block) {
		boolean out = isType(block.getBlockData().getMaterial());
		return isBlacklist() ? !out : out;
	}
	
	public boolean isType(Material type) {
		return getTypes().contains(type);
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

	public List<Material> getTypes() {
		return types;
	}

	public void setTypes(List<Material> types) {
		this.types = types;
	}

	public void setTypes(Material... typeArray) {
		ArrayList<Material> types = new ArrayList<>();
		if(typeArray.length != 0) {
			for(Material type : typeArray) {
				if(!types.contains(type)) {
					types.add(type);
				}
			}
		}
		setTypes(types);
	}

}
