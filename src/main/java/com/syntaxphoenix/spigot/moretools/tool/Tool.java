package com.syntaxphoenix.spigot.moretools.tool;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.tool.abilities.Ability;
import com.syntaxphoenix.spigot.moretools.tool.restriction.NoneRestricted;
import com.syntaxphoenix.spigot.moretools.tool.restriction.Restriction;
import com.syntaxphoenix.spigot.moretools.utils.BaseBuilder;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public abstract class Tool {

    protected final Restriction restriction;
    protected final ToolBaseItem baseItem;
    protected final ToolIdentifier identifier;

    public Tool(String name, BaseBuilder baseItem) {
        this(name, baseItem, Restriction.NONE);
    }

    public Tool(String name, BaseBuilder baseItem, Restriction restriction) {
        this(baseItem.asBase(name), restriction);
    }

    public Tool(String name, ToolIdentifier identifier, BaseBuilder baseItem) {
        this(name, identifier, baseItem, Restriction.NONE);
    }

    public Tool(String name, ToolIdentifier identifier, BaseBuilder baseItem, Restriction restriction) {
        this(identifier, baseItem.asBase(name), restriction);
    }

    public Tool(ToolBaseItem baseItem) {
        this(baseItem, Restriction.NONE);
    }

    public Tool(ToolBaseItem baseItem, Restriction restriction) {
        this((ToolIdentifier) null, baseItem, restriction);
    }

    public Tool(ToolIdentifier identifier, ToolBaseItem baseItem) {
        this(identifier, baseItem, Restriction.NONE);
    }

    public Tool(ToolIdentifier identifier, ToolBaseItem baseItem, Restriction restriction) {
        this.identifier = identifier == null ? new DefaultIdentifier(baseItem) : identifier;
        this.restriction = restriction == null ? Restriction.NONE : restriction;
        this.baseItem = baseItem;
    }

    public boolean isRestricted() {
        return !(restriction instanceof NoneRestricted);
    }

    public String getName() {
        return baseItem.getName();
    }

    public Restriction getRestriction() {
        return restriction;
    }
    
    public ToolIdentifier getIdentifier() {
        return identifier;
    }

    public ToolBaseItem getBaseItem() {
        return baseItem;
    }

    public abstract Ability[] getAbilities();

    public void onBreak(Block block, Direction direction) {}

    public void onUse(Location where, Direction direction, boolean air) {}

}
