package com.gadget.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_8_R3.EnumParticle;

public class Effectz implements Listener {

	static String effects = "§cEffects";
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(e.getTo().getX() != e.getFrom().getX() || e.getTo().getZ() != e.getFrom().getZ()) {
			if(Main.effect.get(p.getName()) == Effects.FLAMES) {
				Api.playEffect(p.getLocation(), EnumParticle.FLAME, 0.1F, 1);
				
			} else if(Main.effect.get(p.getName()) == Effects.VULCANO) {
				Api.playEffect(p.getLocation(), EnumParticle.LAVA, 0F, 1);
		} else if(Main.effect.get(p.getName()) == Effects.PORTAL) {
			Api.playEffect(p.getLocation(), EnumParticle.PORTAL, 0.1F, 1);
	} else if(Main.effect.get(p.getName()) == Effects.HEARTS) {
		Api.playEffect(p.getLocation(), EnumParticle.HEART, 2.5F, 1);
	}
		}
	}
	
    public static void openEffectMenu(Player p) {
    	Inventory inv = Bukkit.createInventory(null, 9, effects);
        	 
    	for(int i = 0; i != 9; i++) {
    		inv.setItem(i, Api.createItem(Material.STAINED_GLASS_PANE, " ", null, 1, 15));
    	}
    	
    	inv.setItem(1, Api.createItem(Material.EYE_OF_ENDER, "§5Portal", "§7This is a portal-effect", 1, 0));
    	inv.setItem(3, Api.createItem(Material.FLINT, "§6Vulcano", "§7This is a vulcano-effect", 1, 0));
    	inv.setItem(5, Api.createItem(Material.REDSTONE_BLOCK, "§cHearts", "§7This is a hearts-effect", 1, 0));
    	inv.setItem(7, Api.createItem(Material.FIREBALL, "§4Flames", "§7This is a flames-effect", 1, 0));
    	
    	p.openInventory(inv);
        }
    
    @EventHandler
    public void on(InventoryClickEvent e) {
    	final Player p = (Player) e.getWhoClicked();

    	
    	
    	if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Portal")) {
    		
	    	if(!p.hasPermission("minetitan.vip")) {
	    		p.sendMessage(Main.prefix + "You must be VIP to get access of this effects. Buy the rank VIP at shop.minetitan.net");
	    		p.closeInventory();
	    		return;
	    	}
    		
    	   changeEffect(p, Effects.PORTAL);
    	   p.sendMessage(Main.prefix + "You have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName() + " §7effect.");
    	   p.closeInventory();
    		} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Vulcano")) {
    			
    	    	if(!p.hasPermission("minetitan.vip")) {
    	    		p.sendMessage(Main.prefix + "You must be VIP to get access of this effects. Buy the rank VIP at shop.minetitan.net");
    	    		p.closeInventory();
    	    		return;
    	    	}
    			
    	    	   changeEffect(p, Effects.VULCANO);
    	    	   p.sendMessage(Main.prefix + "You have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName() + " §7effect.");
    	    	   p.closeInventory();
    		} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Hearts")) {
    			
    	    	if(!p.hasPermission("minetitan.vip")) {
    	    		p.sendMessage(Main.prefix + "You must be VIP to get access of this effects. Buy the rank VIP at shop.minetitan.net");
    	    		p.closeInventory();
    	    		return;
    	    	}
    			
    	    	   changeEffect(p, Effects.HEARTS);
    	    	   p.sendMessage(Main.prefix + "You have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName() + " §7effect.");
    	    	   p.closeInventory();
    		} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Flames")) {
    			
    	    	if(!p.hasPermission("minetitan.vip")) {
    	    		p.sendMessage(Main.prefix + "You must be VIP to get access of this effects. Buy the rank VIP at shop.minetitan.net");
    	    		p.closeInventory();
    	    		return;
    	    	}
    			
    	    	   changeEffect(p, Effects.FLAMES);
    	    	   p.sendMessage(Main.prefix + "You have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName() + " §7effect.");
    	    	   p.closeInventory();
    		}
    	}
    	
    

    public static void changeEffect(Player p, Effects ef) {
    	if(Main.effect.containsKey(p.getName())) {
    	Main.effect.remove(p);
    	}
    	Main.effect.put(p.getName(), ef);
    }
    
}
