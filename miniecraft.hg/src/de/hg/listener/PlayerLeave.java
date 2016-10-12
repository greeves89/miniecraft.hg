package de.hg.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.hg.methods.EndGame;
import de.hg.methods.Game;
import de.hg.utils.message;

public class PlayerLeave implements Listener {

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Game.inGame.contains(p)) {
			Game.inGame.remove(p);
			Bukkit.broadcastMessage(message.prefix + "§8Der Spieler §c" + p.getName() + "§8 hat das Spiel verlassen und ist ausgeschieden!");
		}
		if (Bukkit.getOnlinePlayers().size() == 1) {
			EndGame.regenerate();
		}
		if (Bukkit.getOnlinePlayers().size() == 2) {
			for (Player winner : Bukkit.getOnlinePlayers()) {
				EndGame.setPlayerWinner(winner);
			}
		}
		e.setQuitMessage("");
	}
	
}