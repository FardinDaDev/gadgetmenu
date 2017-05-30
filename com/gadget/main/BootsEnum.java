package com.gadget.main;

import org.bukkit.Color;
import org.bukkit.Effect;

public enum BootsEnum {
	
	SPEEDBOOTS("§bSpeedboots", Color.AQUA, Effect.CRIT),
	HEARTBOOTS("§cHeartboots", Color.RED, Effect.HEART),
	CLOUDBOOTS("§fCloudboots", Color.WHITE, Effect.CLOUD);
	
	private String name;
	private Color bootcolor;
	private Effect effect;
	
	private BootsEnum(String name, Color bootcolor, Effect effect) {
		this.name = name;
		this.bootcolor = bootcolor;
		this.effect = effect;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Color getColor() {
		return this.bootcolor;
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	

}

	

