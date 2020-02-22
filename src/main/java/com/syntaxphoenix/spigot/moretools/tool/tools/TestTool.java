package com.syntaxphoenix.spigot.moretools.tool.tools;

import org.bukkit.Material;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.tool.Tool;
import com.syntaxphoenix.spigot.moretools.tool.abilities.Ability;
import com.syntaxphoenix.spigot.moretools.tool.abilities.SquareBreak;
import com.syntaxphoenix.spigot.moretools.tool.restriction.TypeRestriction;
import com.syntaxphoenix.spigot.moretools.utils.BaseBuilder;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public class TestTool extends Tool {
	
	private SquareBreak square = new SquareBreak(3);

	public TestTool() {
		super(null, BaseBuilder.create("IRON_PICKAXE").name("&cTestTool").asBase(), new TypeRestriction(true, Material.WATER, Material.LAVA));
	}

	@Override
	public Ability[] getAbilities() {
		return new Ability[] {square};
	}
	
	@Override
	public void onBreak(Block block, Direction direction) {
		square.apply(getRestriction(), block, direction);
	}
	
	@Override
	public String getName() {
		return "test";
	}

}
