package com.syntaxphoenix.spigot.moretools.tool.tools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;

import com.syntaxphoenix.spigot.moretools.tool.Tool;
import com.syntaxphoenix.spigot.moretools.tool.abilities.Ability;
import com.syntaxphoenix.spigot.moretools.tool.abilities.SquareBreak;
import com.syntaxphoenix.spigot.moretools.tool.restriction.TypeRestriction;
import com.syntaxphoenix.spigot.moretools.utils.BaseBuilder;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public class TestTool extends Tool {

	private SquareBreak square = new SquareBreak(2);

	public TestTool() {
		super("test",
				BaseBuilder.create("DIAMOND_PICKAXE").name("&7Steinhammer").enchant(Enchantment.ARROW_INFINITE, 1)
						.enchant(Enchantment.DIG_SPEED, 4).enchant(Enchantment.DURABILITY, 3),
				new TypeRestriction(false, Material.STONE, Material.GRANITE, Material.ANDESITE, Material.DIORITE,
						Material.SANDSTONE, Material.TERRACOTTA, Material.BLACK_TERRACOTTA, Material.BLUE_TERRACOTTA,
						Material.BROWN_TERRACOTTA, Material.RED_TERRACOTTA, Material.PINK_TERRACOTTA,
						Material.ORANGE_TERRACOTTA, Material.MAGENTA_TERRACOTTA, Material.YELLOW_TERRACOTTA,
						Material.LIME_TERRACOTTA, Material.GREEN_TERRACOTTA, Material.PURPLE_TERRACOTTA,
						Material.LIGHT_BLUE_TERRACOTTA, Material.CYAN_TERRACOTTA, Material.GRAY_TERRACOTTA,
						Material.LIGHT_GRAY_TERRACOTTA, Material.STONE_BRICKS, Material.COBBLESTONE));
	}

	@Override
	public Ability[] getAbilities() {
		return new Ability[] { square };
	}

	@Override
	public void onBreak(Block block, Direction direction) {
		square.apply(getRestriction(), block, direction);
	}

}
