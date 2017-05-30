package com.gadget.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

import net.minecraft.server.v1_8_R3.EnumParticle;

public class Gadget implements Listener {

	public static String nameInv = "§7Gadget-Menu";
	public static ArrayList<String> UsingInvisible = new ArrayList<String>();
	
	
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.BLAZE_ROD) {
		   	Gui(p);
		   	p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
		   	e.setCancelled(true);	
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase(nameInv)) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§cEffects")) {
				Effectz.openEffectMenu(p);
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cBoots")) {
				Boots.openBootsMenu(p);
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cWardrobe")) {
				Wardrobe.openWardrobeMenu(p);
			} else {
				return;
			}
		}
		
	}
	
	public static void Gui(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, nameInv);
		for(int i = 0; i != 9; i++) {
			inv.setItem(i, Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15));
		}
		inv.setItem(4, Api.createItem(Material.NETHER_STAR, "§cEffects", "§7Open the effects menu.", 1, 0));
		inv.setItem(2, Api.createItem(Material.LEATHER_HELMET, "§cWardrobe", "§7Open the wardrobe", 1, 0));
		inv.setItem(6, Api.createItem(Material.LEATHER_BOOTS, "§cBoots", "§7Open the special boot-effects menu", 1, 0));
		
		p.openInventory(inv);
	}
	
}

