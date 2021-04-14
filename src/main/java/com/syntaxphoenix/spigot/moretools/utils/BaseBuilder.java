package com.syntaxphoenix.spigot.moretools.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.syntaxphoenix.spigot.moretools.tool.ToolBaseItem;

public class BaseBuilder {
	
	public static BaseBuilder create(Material material) {
		return new BaseBuilder(material);
	}
	
	public static BaseBuilder create(String name) {
		return new BaseBuilder(Material.valueOf(name.toUpperCase()));
	}
	
	private ItemStack stack;
	private ItemMeta meta;
	
	public BaseBuilder(Material material) {
		this.stack = new ItemStack(material);
		meta = stack.getItemMeta();
	}
	
	public BaseBuilder name(String name) {
		meta.setDisplayName(Message.color(name));
		return this;
	}
	
	public BaseBuilder enchant(Enchantment ench, int level) {
		meta.addEnchant(ench, level, true);
		return this;
	}
	
	public ToolBaseItem asBase(String id) {
		stack.setItemMeta(meta);
		return new ToolBaseItem(id, stack);
	}
	
	public ItemStack asItemStack() {
		stack.setItemMeta(meta);
		return stack;
	}
	
}
