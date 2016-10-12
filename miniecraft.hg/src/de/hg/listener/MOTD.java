package de.hg.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.hg.methods.Game;

public class MOTD implements Listener {

	public void onServerList(ServerListPingEvent e) {
		if (Game.isFull) {
			e.setMotd("§cFULL");
		} else if (Game.isRunning) {
			e.setMotd("§bläuft bereits");
		} else if (Game.didPlayerCanJoin) {
			e.setMotd("§2join");
		}
		e.setMaxPlayers(64);
	}
	
}
