package de.hg.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class DisplaynameSetup implements Listener {

	@EventHandler
	public void onJoin(PlayerLoginEvent e) {
		
		Player p = e.getPlayer();
		if (p.hasPermission("server.headadmin")) {
			p.setDisplayName("§4" + p.getName());
		} else if (p.hasPermission("server.admin")) {
			p.setDisplayName("§c" + p.getName());
		} else if (p.hasPermission("server.developer")) {
			p.setDisplayName("§0" + p.getName());
		} else if (p.hasPermission("server.moderator")) {
			p.setDisplayName("§5" + p.getName());
		} else if(p.hasPermission("server.moderator.trial")) {
			p.setDisplayName("§d" + p.getName());
		} else if (p.hasPermission("server.builder")) {
			p.setDisplayName("§e" + p.getName());
		} else if(p.hasPermission("server.supporter")) {
			p.setDisplayName("§8" + p.getName());
		} else if (p.hasPermission("server.friend")) {
			p.setDisplayName("§b" + p.getName());
		} else if (p.hasPermission("server.premium")) {
			p.setDisplayName("§6" + p.getName());
		} else {
			p.setDisplayName("§7" + p.getName());
		}
		
	}
}
