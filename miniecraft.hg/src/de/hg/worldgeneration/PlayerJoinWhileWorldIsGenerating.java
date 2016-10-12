package de.hg.worldgeneration;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.hg.methods.Game;

public class PlayerJoinWhileWorldIsGenerating implements Listener {

	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!Game.didPlayerCanJoin) {
			p.kickPlayer("§cDer Server startet gerade neu!");
		}
	}
	
}
