package com.gadget.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Main.MenuItem(p);
		
		for(Player p1 : Bukkit.getServer().getOnlinePlayers()) {
			if(p1 != p1.getPlayer()) {
				if(Skulls.usingClock.contains(p.getName())) {
					p.hidePlayer(e.getPlayer());
				}
			} else {
				p.showPlayer(e.getPlayer());
			}
		}
		
	}
	
}
