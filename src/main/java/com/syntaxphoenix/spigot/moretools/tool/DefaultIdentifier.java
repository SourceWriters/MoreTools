package com.syntaxphoenix.spigot.moretools.tool;

import org.bukkit.inventory.ItemStack;

public class DefaultIdentifier implements ToolIdentifier {
	
	private ToolBaseItem item;
	public DefaultIdentifier(ToolBaseItem item) {
		this.item = item;
	}

	@Override
	public boolean identify(ItemStack input) {
		return item.isSimilar(input);
	}

}
