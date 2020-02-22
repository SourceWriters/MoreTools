package com.syntaxphoenix.spigot.moretools;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.syntaxphoenix.spigot.moretools.listener.ToolListener;
import com.syntaxphoenix.spigot.moretools.tool.ToolManager;
import com.syntaxphoenix.spigot.moretools.tool.tools.TestTool;

public class MoreTools extends JavaPlugin {
	
	private ToolManager manager;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ToolListener(manager = new ToolManager()), this);
		
		manager.register(new TestTool());
		
	}

}
