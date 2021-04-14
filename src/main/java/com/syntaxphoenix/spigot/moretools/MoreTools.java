package com.syntaxphoenix.spigot.moretools;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import com.syntaxphoenix.spigot.moretools.listener.ToolListener;
import com.syntaxphoenix.spigot.moretools.tool.ToolManager;
import com.syntaxphoenix.spigot.moretools.tool.tools.TestTool;
import com.syntaxphoenix.syntaxapi.utils.java.tools.Container;

public class MoreTools extends JavaPlugin {

    private static final Container<MoreTools> PLUGIN = Container.of();
    private static final HashMap<String, NamespacedKey> KEYS = new HashMap<>();

    private ToolManager manager;

    @Override
    public void onLoad() {
        PLUGIN.replace(this);
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ToolListener(manager = new ToolManager()), this);

        TestTool tool = new TestTool();
        manager.register(tool);

        ShapedRecipe shaped = new ShapedRecipe(new NamespacedKey(this, "test"), tool.getBaseItem().copy());

        shaped.shape("ddd", "xox", "xox");

        shaped.setIngredient('d', Material.DIAMOND_BLOCK);
        shaped.setIngredient('o', Material.OBSIDIAN);
        shaped.setIngredient('x', Material.AIR);

        Bukkit.addRecipe(shaped);

    }

    public static MoreTools get() {
        return PLUGIN.get();
    }

    public static NamespacedKey createKey(String name) {
        return KEYS.computeIfAbsent(name, key -> new NamespacedKey(get(), key));
    }

}
