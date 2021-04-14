package com.syntaxphoenix.spigot.moretools.utils.item;

import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;

import com.syntaxphoenix.spigot.moretools.utils.reflect.CraftBukkit;
import com.syntaxphoenix.spigot.moretools.utils.reflect.Reflection;

public class ItemStackHelper {

    private ItemStackHelper() {}

    public static boolean bukkitSimiliar(ItemStack base, ItemStack input) {
        if (base == null) {
            return false;
        } else if (base == input) {
            return true;
        } else {
            return input.getType() == base.getType() && base.hasItemMeta() == input.hasItemMeta()
                && (!base.hasItemMeta() || Bukkit.getItemFactory().equals(base.getItemMeta(), input.getItemMeta()));
        }
    }

    public static boolean isSimilar(ItemStack base, ItemStack input, boolean exact) {
        boolean bukkit = bukkitSimiliar(base, input);
        boolean meta = false;
        if (base.hasItemMeta() && input.hasItemMeta()) {
            CustomItemTagContainer inputTag = input.getItemMeta().getCustomTagContainer();
            CustomItemTagContainer baseTag = base.getItemMeta().getCustomTagContainer();
            if (exact) {
                meta = hasSameTags(baseTag, inputTag);
            } else {
                meta = containsTags(baseTag, inputTag);
            }
        }
        return meta && bukkit;
    }

    public static boolean hasSameTags(CustomItemTagContainer container1, CustomItemTagContainer container2) {
        if (container1.isEmpty() && container2.isEmpty()) {
            return true;
        }
        if (container1.isEmpty() || container2.isEmpty()) {
            return false;
        }
        Set<String> keys1 = getKeys(container1);
        Set<String> keys2 = getKeys(container2);
        if (keys1.size() != keys2.size()) {
            return false;
        }
        for (String key : keys1) {
            if (!keys2.contains(key)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsTags(CustomItemTagContainer container1, CustomItemTagContainer container2) {
        if (container1.isEmpty() && container2.isEmpty()) {
            return true;
        }
        if (container1.isEmpty()) {
            return true;
        }
        if (container2.isEmpty()) {
            return false;
        }
        Set<String> keys1 = getKeys(container1);
        Set<String> keys2 = getKeys(container2);
        for (String key : keys1) {
            if (!keys2.contains(key)) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> getKeys(CustomItemTagContainer container) {
        CraftBukkit bukkit = Reflection.getCraftBukkit().create("customItemTag", "inventory.tags.CraftCustomItemTagContainer");
        if (!bukkit.containsField("tagMap")) {
            bukkit.searchField("tagMap", "customTags");
        }
        @SuppressWarnings("unchecked")
        Map<String, ?> map = (Map<String, ?>) bukkit.getFieldValue("tagMap", container);
        return map.keySet();
    }

}
