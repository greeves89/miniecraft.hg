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
					p.kickPlayer("§bYou have been killed!\n"
							+ "§bkilled by: §c" + killer.getName() + "\n"
									+ "§bHeart's §c" + hearts + "\n");
				} else {
					double hearts = killer.getHealth() / 2;
					p.kickPlayer("§bYou have been killed!\n"
							+ "§bkilled by: §c" + killer.getName() + "\n"
									+ "§bHeart's §c" + hearts + "\n");
				}
			} else {
				if (Bukkit.getOnlinePlayers().size() == 3 || Bukkit.getOnlinePlayers().size() == 2) {
					p.kickPlayer("§bYou have been eliminated");
				} else {
					p.kickPlayer("§bYou have been eliminated");
				}
			}
		}
		statsMySQL.updateDeaths(p.getUniqueId(), true, 1);
		if (killer instanceof Player) {
			statsMySQL.updateKills(killer.getUniqueId(), true, 1);
			ScoreboardClass.updateScoreboard(killer);
		}
		ScoreboardClass.updateScoreboard(p);
	}
	
}
