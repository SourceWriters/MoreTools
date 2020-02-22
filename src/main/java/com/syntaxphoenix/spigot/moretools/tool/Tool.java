package com.syntaxphoenix.spigot.moretools.tool;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.tool.abilities.Ability;
import com.syntaxphoenix.spigot.moretools.tool.restriction.NoneRestricted;
import com.syntaxphoenix.spigot.moretools.tool.restriction.Restriction;
import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public abstract class Tool {
	
	private final ToolIdentifier identifier;
	protected final Restriction restriction;
	protected final ToolBaseItem baseItem;
	
	public Tool(ToolIdentifier identifier, ToolBaseItem baseItem) {
		this(identifier, baseItem, Restriction.NONE);
	}
	
	public Tool(ToolIdentifier identifier, ToolBaseItem baseItem, Restriction restriction) {
		this.restriction = restriction == null ? Restriction.NONE : restriction;
		this.baseItem = baseItem;
		if(identifier == null) {
			if(this instanceof ToolIdentifier) {
				this.identifier = (ToolIdentifier) this;
			} else {
				this.identifier = new DefaultIdentifier(baseItem);
			}
		} else {
			this.identifier = identifier;
		}
	}
	
	public boolean isRestricted() {
		return !(restriction instanceof NoneRestricted);
	}
	
	public String getName() {
		return getClass().getSimpleName();
	}

	public ToolIdentifier getIdentifier() {
		return identifier;
	}

	public Restriction getRestriction() {
		return restriction;
	}

	public ToolBaseItem getBaseItem() {
		return baseItem;
	}
	
	public abstract Ability[] getAbilities();
	
	public void onBreak(Block block, Direction direction) {}
	public void onUse(Location where, Direction direction, boolean air) {}

}
