package com.syntaxphoenix.spigot.moretools.tool;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;

import com.syntaxphoenix.spigot.moretools.MoreTools;
import com.syntaxphoenix.syntaxapi.utils.java.tools.Container;

public class ToolBaseItem {

    private static final Container<NamespacedKey> KEY = Container.of();

    private static NamespacedKey getKey() {
        if (KEY.isPresent()) {
            return KEY.get();
        }
        return KEY.replace(MoreTools.createKey("tool")).get();
    }

    private final String name;
    private final ItemStack base;

    public ToolBaseItem(String name, ItemStack base) {
        this.name = name;
        this.base = base;
        applyData();
    }

    public ItemStack copy() {
        return base.clone();
    }

    public void give(Player player) {
        player.getInventory().addItem(base);
    }

    public String getName() {
        return name;
    }

    public boolean isTool(ItemStack input) {
        ItemMeta meta = input.getItemMeta();
        if (meta == null) {
            return false;
        }
        CustomItemTagContainer container = meta.getCustomTagContainer();
        if (container == null || container.hasCustomTag(getKey(), ItemTagType.STRING)) {
            return false;
        }
        return name.equals(container.getCustomTag(getKey(), ItemTagType.STRING));
    }

    private void applyData() {
        ItemMeta meta = base.getItemMeta();
        if (meta == null) {
            throw new NullPointerException("Item can't have meta!");
        }
        CustomItemTagContainer container = meta.getCustomTagContainer();
        if (container == null) {
            throw new NullPointerException("Item can't have custom tags!");
        }
        container.setCustomTag(getKey(), ItemTagType.STRING, name);
    }

}
