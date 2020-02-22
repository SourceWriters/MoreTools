package com.syntaxphoenix.spigot.moretools.utils;

import org.bukkit.Location;

import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;

public class LocationTools {
	
	public static boolean isBetween(Location check, Location point1, Location point2) {
		int x1 = point1.getBlockX();
		int x2 = point2.getBlockX();
		int y1 = point1.getBlockY();
		int y2 = point2.getBlockY();
		int z1 = point1.getBlockZ();
		int z2 = point2.getBlockZ();
		
		int x = check.getBlockX();
		int y = check.getBlockY();
		int z = check.getBlockZ();
		
		int xmi;
		int xma;
		if(x2 > x1) {
			xma = x2;
			xmi = x1;
		} else {
			xma = x1;
			xmi = x2;
		}
		
		int ymi;
		int yma;
		if(y2 > y1) {
			yma = y2;
			ymi = y1;
		} else {
			yma = y1;
			ymi = y2;
		}
		
		int zmi;
		int zma;
		if(z2 > z1) {
			zma = z2;
			zmi = z1;
		} else {
			zma = z1;
			zmi = z2;
		}
		
		return (x <= xma && xmi <= x) && (y <= yma && ymi <= y) && (z <= zma && zmi <= z);
	}
	
	public static Direction getDirection(Location player) {
		Direction direction = new Direction();
		
		direction.setRotationX(player.getYaw());
		direction.setRotationY(player.getPitch());
		
		return direction;
	}

}
