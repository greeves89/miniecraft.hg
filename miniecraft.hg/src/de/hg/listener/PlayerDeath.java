package de.hg.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.hg.methods.Game;
import de.hg.mysql.statsMySQL;
import de.hg.utils.ScoreboardClass;

public class PlayerDeath implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		Player killer = e.getEntity().getKiller();
		if (Game.isRunning) {
			if (killer != null) {
				if (Bukkit.getOnlinePlayers().size() == 3 || Bukkit.getOnlinePlayers().size() == 2) {
					double hearts = killer.getHealth() / 2;
					p.kickPlayer("§bDu bist leider ausgeschieden!\n"
							+ "§bgetötet von: §c" + killer.getName() + "\n"
									+ "§bAnzahl der Herzen: §c" + hearts + "\n"
											+ "Du hast ein Geschenk für den belegten Platz bekommen!");
				} else {
					double hearts = killer.getHealth() / 2;
					p.kickPlayer("§bDu bist leider ausgeschieden!\n"
							+ "§bgetötet von: §c" + killer.getName() + "\n"
									+ "§bAnzahl der Herzen: §c" + hearts + "\n"
											+ "Du kannst nun wieder ganz normal auf den Lobbyserver verbinden!");
				}
			} else {
				if (Bukkit.getOnlinePlayers().size() == 3 || Bukkit.getOnlinePlayers().size() == 2) {
					p.kickPlayer("§bDu bist leider ausgeschieden!\n"
							+ "§eDu kannst nun wieder ganz normal auf den Lobbyserver verbinden!\n"
							+ "§eDu hast ein Geschenk für den belegten Platz bekommen!");
				} else {
					p.kickPlayer("§bDu bist leider ausgeschieden!\n"
							+ "§eDu kannst nun wieder ganz normal auf den Lobbyserver verbinden!");
				}
			}
		}
		Bukkit.dispatchCommand(p, "server lobby");
		statsMySQL.updateDeaths(p.getUniqueId(), true, 1);
		if (killer instanceof Player) {
			ScoreboardClass.updateScoreboard(killer);
			statsMySQL.updateKills(killer.getUniqueId(), true, 1);
		}
		ScoreboardClass.updateScoreboard(p);
	}
	
}
