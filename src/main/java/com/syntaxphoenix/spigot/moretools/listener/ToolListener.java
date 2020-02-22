package com.syntaxphoenix.spigot.moretools.listener;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import com.syntaxphoenix.spigot.moretools.tool.Tool;
import com.syntaxphoenix.spigot.moretools.tool.ToolManager;
import com.syntaxphoenix.spigot.moretools.utils.LocationTools;

public class ToolListener implements Listener {
	
	private ToolManager manager;
	
	public ToolListener(ToolManager manager) {
		this.manager = manager;
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		EntityEquipment equip = player.getEquipment();
		ItemStack stack = equip.getItemInMainHand();
		if(stack == null) {
			return;
		}
		Optional<Tool> option = manager.tryIdentify(stack);
		if(option.isPresent()) {
			Tool tool = option.get();
			CompletableFuture.runAsync(() -> tool.onBreak(event.getBlock(), LocationTools.getDirection(player.getLocation())));
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		manager.getTool("test").getBaseItem().give(player);
	}

}
