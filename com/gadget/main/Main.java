package com.gadget.main;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static HashMap<String, Effects> effect = new HashMap<String, Effects>();
	public static Main plugin;
	public static String prefix = "§a§lMine§2§lTitan §7";
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("Created by Fardin");
		registerCommands();
		registerListeners();
	}

	@Override
	public void onDisable() {
		plugin = null;
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Effectz(), this);
		pm.registerEvents(new Gadget(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new Boots(), this);
		pm.registerEvents(new Wardrobe(), this);
		pm.registerEvents(new Skulls(), this);
		
	}

	private void registerCommands() {
		
		
	}
	
	public static void MenuItem(Player p) {
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);
	    
	    ItemStack menu = new ItemStack(Material.BLAZE_ROD);
	    ItemMeta menuMeta = menu.getItemMeta();
	    
	    menuMeta.setDisplayName("§e§lGadget-Menu");
	    menu.setItemMeta(menuMeta);
	    
	    p.getInventory().setItem(7, menu);
	    
	    ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1 , (byte)3);
	    
	    SkullMeta profileMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);

	    profileMeta.setOwner(p.getName());

	    profileMeta.setLore(Arrays.asList("§7Seeing your stats and profile."));
	    
	    profileMeta.setDisplayName("§cMy profile");
	    
	    profile.setItemMeta(profileMeta);
 
	    p.getInventory().setItem(1, profile);
	    
	}
}
