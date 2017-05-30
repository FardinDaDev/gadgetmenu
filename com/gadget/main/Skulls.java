package com.gadget.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Skulls implements Listener {

	public static String nameInv = "§cMy Profile";
	public static ArrayList<String> usingClock = new ArrayList<String>();

	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		
		
		if(e.getInventory().getName().equalsIgnoreCase(nameInv)) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cYoutube channel")) {
				YoutubechannelGui(p);
			} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§aStats")) {
				StatsGui(p);
			} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cSettings")) {
				SettingsGui(p);
		    				  
			   	} 
			} else {
				return;
			}
				 
			
			
		}

	
	

	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.SKULL_ITEM) {
		   	Gui(p);
		   	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
		   	e.setCancelled(true);	
		   
		  

	   	}
		
		}
		
		   	
		
	
	
	public static void Gui(Player p) {
		Inventory inv = Bukkit.createInventory(null, 5*9, nameInv);

	    ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1 , (byte)3);
	    
	    SkullMeta profileMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);

	    profileMeta.setOwner("JeroenYT");

	    profileMeta.setDisplayName("§cYoutube channel");
	    profileMeta.setLore(Arrays.asList("§7This is the owners youtube channel."));
	    
	    profile.setItemMeta(profileMeta);
		
		for(int i = 0; i != 5*9; i++) {
			inv.setItem(i, Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15));
		}
		
		inv.setItem(22, profile);
		inv.setItem(23, Api.createItem(Material.GOLD_SWORD, "§aStats", "§7All your kills and deaths.", 1, 0));
		inv.setItem(21, Api.createItem(Material.REDSTONE, "§cSettings", "§7Change your settings", 1, 0));
		
		p.openInventory(inv);
	}
	
	public static void YoutubechannelGui(Player p) {
		
		p.sendMessage(Main.prefix + "The channel is §cNormaalGamen");
		p.sendMessage(Main.prefix + "Link: §chttps://www.youtube.com/c/normaalgamen/");
		p.closeInventory();
		
	}
	
	private void StatsGui(Player p) {
		
		p.sendMessage(Main.prefix + "This feature will be added in the future.");
		p.closeInventory();
		
	}
	
	public static void SettingsGui(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§cSettings");
		
		for(int i = 0; i != 54; i++) {
			inv.setItem(i, Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15));
		}
			
			for(int i = 0; i != 5*9; i++) {
				inv.setItem(i, Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15));
		
		inv.setItem(22, Api.createItem(Material.WATCH, "§cInvisible", "§7Turn the players on or off.", 1, 0));
		inv.setItem(31, Api.createItem(Material.REDSTONE_BLOCK, "§cVisible", "§7Makes players visible", 1, 0));
		inv.setItem(21, Api.createItem(Material.ARROW, "§cDutch", "§7Change the language to dutch!", 1, 0));
		inv.setItem(30, Api.createItem(Material.APPLE, "§cEnglish", "§7Change the language to english!", 1, 0));
		p.openInventory(inv);
			}
	}
	
	@EventHandler
	public void on1(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
	if (e.getCurrentItem().getItemMeta().getDisplayName().contains(" ")) {
			e.setCancelled(true);
			
	}  else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Invisible")) {
		for(Player other : Bukkit.getServer().getOnlinePlayers()) {
	   		p.hidePlayer(other);
	   		p.sendMessage(Main.prefix + "The players are now hidden!");
	   		p.closeInventory();
	   	return;
	   	}
	} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Visible")) {
	   	for(Player other : Bukkit.getServer().getOnlinePlayers()) {
	   		p.showPlayer(other);
	   		p.sendMessage(Main.prefix + "The players are now visible!");
	   		p.closeInventory();
	   		e.setCancelled(true);
	   		return;
    				  
	   	} 
	}

	
	
	   	} 
	

    	 
    	}

     	   
    	
    
	
     	   
    	
    	
	

