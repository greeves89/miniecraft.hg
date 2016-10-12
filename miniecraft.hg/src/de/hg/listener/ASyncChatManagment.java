package de.hg.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ASyncChatManagment implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("server.premium")) {
			String msg = ChatColor.translateAlternateColorCodes('&', e.getMessage());
			e.setFormat(p.getDisplayName() + "§7 >> §f" + msg);
		} else {
			e.setFormat(p.getDisplayName() + "§7 >> §f" + e.getMessage());
		}
	}
	
}
