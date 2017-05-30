package com.gadget.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Wardrobe implements Listener {

	private static String nameInv = "§7Wardrobe";
	ArrayList<String> wait = new ArrayList<String>();
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().contains(nameInv)) {
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.LEATHER_HELMET) {
				p.getInventory().setHelmet(e.getCurrentItem());
			} else if(e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				p.getInventory().setChestplate(e.getCurrentItem());
			} else if(e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS) {
				p.getInventory().setLeggings(e.getCurrentItem());
			} else if(e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				p.getInventory().setBoots(e.getCurrentItem());
			}
			p.closeInventory();
			wait.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

				@Override
				public void run() {
					wait.remove(p.getName());
					
				}
				
			}, 30);
		}
		
	}
	
	public static void openWardrobeMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 4*9, nameInv);
		setItemInv(inv, 0, Color.RED);
		setItemInv(inv, 1, Color.BLACK);
		setItemInv(inv, 2, Color.LIME);
		setItemInv(inv, 3, Color.NAVY);
		setItemInv(inv, 4, Color.PURPLE);
		setItemInv(inv, 5, Color.GRAY);
		setItemInv(inv, 6, Color.ORANGE);
		setItemInv(inv, 7, Color.WHITE);
		setItemInv(inv, 8, Color.BLUE);
		
		p.openInventory(inv);
	}

	private static void setItemInv(Inventory inv, int slot, Color c) {
		
		inv.setItem(slot, createItem(Material.LEATHER_HELMET, c, "§bHelmet"));
		inv.setItem(slot+9, createItem(Material.LEATHER_CHESTPLATE, c, "§bChestplate"));
		inv.setItem(slot+9+9, createItem(Material.LEATHER_LEGGINGS, c, "§bLeggings"));
		inv.setItem(slot+9+9+9, createItem(Material.LEATHER_BOOTS, c, "§bBoots"));
		
	}
	
	private static ItemStack createItem(Material m, Color c, String name) {
		
		ItemStack is = new ItemStack(m);
		LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
		im.setDisplayName(name);
		im.setColor(c);
		is.setItemMeta(im);
		
		return is;
		
	}
	
}
