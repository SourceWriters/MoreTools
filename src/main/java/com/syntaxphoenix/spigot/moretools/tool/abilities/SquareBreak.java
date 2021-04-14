package com.syntaxphoenix.spigot.moretools.tool.abilities;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.syntaxphoenix.spigot.moretools.utils.direction.Direction;
import com.syntaxphoenix.spigot.moretools.utils.direction.Vertical;

public class SquareBreak extends BreakAbility {
	
	private int radius;
	
	public SquareBreak(int radius) {
		setRadius(radius);
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	@Override
	public Location[] calculate(Direction direction, Location start) {
		Vertical vertical = direction.getVertical();
		float rotation = direction.getRotationX();
		Location[] output = new Location[dbl(rad())];
		if(vertical == Vertical.MID) {
			if(((rotation <= 0 && rotation > -45f) || (rotation >= -360.0f && rotation <= -315f)) || (rotation < -135f && rotation >= -225f)) {
				eastWest(output, start);
			} else {
				northSouth(output, start);
			}
		} else {
			upDown(output, start);
		}
		return output;
	}

	@Override
	public void breakBlock(Block block) {
		block.breakNaturally();
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public void upDown(Location[] output, Location start) {
		int x = start.getBlockX();
		int y = start.getBlockY();
		int z = start.getBlockZ();
		int[][] input = calc(x, z);
		for(int index = 0; index < output.length; index++) {
			output[index] = new Location(start.getWorld(), input[index][0], y, input[index][1]);
		}
	}
	
	public void northSouth(Location[] output, Location start) {
		int x = start.getBlockX();
		int y = start.getBlockY();
		int z = start.getBlockZ();
		int[][] input = calc(z, y);
		for(int index = 0; index < output.length; index++) {
			output[index] = new Location(start.getWorld(), x, input[index][1], input[index][0]);
		}
	}
	
	public void eastWest(Location[] output, Location start) {
		int x = start.getBlockX();
		int y = start.getBlockY();
		int z = start.getBlockZ();
		int[][] input = calc(x, y);
		for(int index = 0; index < output.length; index++) {
			output[index] = new Location(start.getWorld(), input[index][0], input[index][1], z);
		}
	}
	
	public int[][] calc(int in1, int in2) {
		int current = 0;
		int[][] output = new int[dbl(rad())][2];
		for(int out1 = in1 - radius; out1 <= in1 + radius; out1++) {
			for(int out2 = in2 - radius; out2 <= in2 + radius; out2++) {
				output[current][0] = out1;
				output[current][1] = out2;
				current++;
			}
		}
		return output;
	}
	
	private int dbl(int in) {
		return in * in;
	}
	
	private int rad() {
		return (radius * 2) + 1;
	}
	
	/*
	 * 
	 * 
	 * 
	 */

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
