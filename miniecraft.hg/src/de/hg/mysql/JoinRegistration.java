package de.hg.mysql;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinRegistration implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!statsMySQL.didPlayerExist(p.getUniqueId())) {
			statsMySQL.insertUser(p.getUniqueId(), p);
		}
	}
	
}
