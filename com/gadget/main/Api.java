package com.gadget.main;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Api {

	public static ItemStack createItem(Material m, String name, String lore, int number, int nextID) {
		
		ItemStack is = new ItemStack(m, number, (short) nextID);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lore));
		is.setAmount(number);
		is.setItemMeta(im);
		
		return is;
	}

	public static void playEffect(Location loc, EnumParticle ep, float f, int number) {
	       PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
	    		   ep,
	    		   true,
	    		   (float) loc.getX(), 
	    		   (float) loc.getY(), 
	    		   (float) loc.getZ(), 
	    		   f, 
	    		   f, 
	    		   f, 
	    		   0.0F,
	    		   number, 
	    		   0, 
	    		   0);
	       for(Player p : Bukkit.getOnlinePlayers()) {
	    	   ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	       }
	}
	
}
