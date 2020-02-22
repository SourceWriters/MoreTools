package com.syntaxphoenix.spigot.moretools.tool;

import java.util.HashMap;
import java.util.Optional;

import org.bukkit.inventory.ItemStack;

public class ToolManager {
	
	private HashMap<String, Tool> tools = new HashMap<>();
	
	public boolean register(Tool tool) {
		if(!tools.containsKey(tool.getName())) {
			tools.put(tool.getName(), tool);
			return true;
		}
		return false;
	}
	
	public boolean exists(String name) {
		return tools.containsKey(name);
	}
	
	public Tool getTool(String name) {
		return tools.get(name);
	}
	
	public Optional<Tool> tryIdentify(ItemStack indentify) {
		return tools.values().stream().filter(tool -> tool.getIdentifier().identify(indentify)).findFirst();
	}

}
