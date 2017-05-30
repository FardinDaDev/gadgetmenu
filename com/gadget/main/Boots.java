package com.gadget.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Boots implements Listener {

	public static String invname = "§7Boots";
	
	public static void openBootsMenu(Player p) {
	    
        int snaar = 1;
        if(BootsEnum.values().length > 9) snaar = 2;
        if(BootsEnum.values().length > 2*9) snaar = 3;
        if(BootsEnum.values().length > 3*9) snaar = 4;
        if(BootsEnum.values().length > 4*9) snaar = 5;
        if(BootsEnum.values().length > 5*9) snaar = 6;
        
        Inventory inv = Bukkit.createInventory(null, snaar*9, invname);
        p.openInventory(inv);
        
        for(int i = 0; i < inv.getSize(); i++) {
       	 inv.setItem(i, new ItemStack(Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15)));
       	 
        }
        
        int slot = 0;
        for(BootsEnum boots : BootsEnum.values()) {
       	 ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
       	 LeatherArmorMeta meta = (LeatherArmorMeta) boot.getItemMeta();
       	 meta.setColor(boots.getColor());
       	 meta.setDisplayName(boots.getName());
       	 boot.setItemMeta(meta);
       	 
       	 inv.setItem(slot, boot);
       	 slot++;
        }
        
		
		
		return;
		
		
		
	}
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem() != null) {
			if(e.getClickedInventory().getName().equals(invname)) {
				e.setCancelled(true);
				
				for(BootsEnum boots : BootsEnum.values()) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equals(boots.getName())) {
						p.getInventory().setBoots(e.getCurrentItem());
						p.sendMessage(Main.prefix +  "You have chosen §e" + boots.getName());
						p.closeInventory();
						
						break;	
		}
				}
			}
			
		}
		
	}
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getInventory().getBoots() != null) {
			String bootname = p.getInventory().getBoots().getItemMeta().getDisplayName();
					
					for(BootsEnum boots : BootsEnum.values()) {
						if(bootname.equals(boots.getName())) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.spigot().playEffect(p.getLocation(), boots.getEffect(), 0, 0, 0, 0, 0, 0, 10, 0);
							}
							break;
						}
					}
		}
		
	}
	

		
	}


