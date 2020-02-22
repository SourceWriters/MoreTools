package com.syntaxphoenix.spigot.moretools.tool;

import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;

import com.syntaxphoenix.spigot.moretools.utils.reflect.CraftBukkit;
import com.syntaxphoenix.spigot.moretools.utils.reflect.Reflection;

public class ToolBaseItem {
	
	private ItemStack base;
	private boolean exact = false;
	
	public ToolBaseItem(ItemStack base) {
		this.base = base;
	}
	
	public ToolBaseItem(ItemStack base, boolean exact) {
		this.base = base;
		this.exact = exact;
	}

	public ItemStack copy() {
		return base.clone();
	}
	
	public void give(Player player) {
		player.getInventory().addItem(base);
	}
	
	public boolean isSimilar(ItemStack input) {
		boolean bukkit = base.isSimilar(input);
		if(!bukkit) {
			boolean meta = false;
			if(base.hasItemMeta() && input.hasItemMeta()) {
				CustomItemTagContainer inputTag = input.getItemMeta().getCustomTagContainer();
				CustomItemTagContainer baseTag = base.getItemMeta().getCustomTagContainer();
				if(exact) {
					meta = hasSameTags(baseTag, inputTag);
				} else {
					meta = containsTags(baseTag, inputTag);
				}
			}
			return meta && base.getType() == input.getType();
		} else {
			return bukkit;
		}
	}
	
	private boolean hasSameTags(CustomItemTagContainer container1, CustomItemTagContainer container2) {
		if(container1.isEmpty() && container2.isEmpty()) {
			return true;
		}
		if(container1.isEmpty() || container2.isEmpty()) {
			return false;
		}
		Set<String> keys1 = getKeys(container1);
		Set<String> keys2 = getKeys(container2);
		if(keys1.size() != keys2.size()) {
			return false;
		}
		for(String key : keys1) {
			if(!keys2.contains(key)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean containsTags(CustomItemTagContainer container1, CustomItemTagContainer container2) {
		if(container1.isEmpty() && container2.isEmpty()) {
			return true;
		}
		if(container1.isEmpty()) {
			return true;
		}
		if(container2.isEmpty()) {
			return false;
		}
		Set<String> keys1 = getKeys(container1);
		Set<String> keys2 = getKeys(container2);
		for(String key : keys1) {
			if(!keys2.contains(key)) {
				return false;
			}
		}
		return true;
	}
	
	private Set<String> getKeys(CustomItemTagContainer container){
		CraftBukkit bukkit = Reflection.getCraftBukkit().create("customItemTag", "inventory.tags.CraftCustomItemTagContainer");
		if(!bukkit.containsField("tagMap")) {
			bukkit.searchField("tagMap", "customTags");
		}
		@SuppressWarnings("unchecked")
		Map<String, ?> map = (Map<String, ?>) bukkit.getFieldValue("tagMap", container);
		return map.keySet();
	}

}
