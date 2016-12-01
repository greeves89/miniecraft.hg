package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.hg.fileconfiguration.BasicConfig;
import de.hg.main.main;
import de.hg.utils.message;

public class startup {

	static int countdown;
	public static int time;
	/**
	 * The Number of Clients is the number how many people must be online to start the game
	 * @param p - Player 
	 * @param time - when the Game starts
	 * @author Eric Dupont
	 */
	public static void startGame(final int clients) {
		
		Game.didPlayerCanJoin = true;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if (time != 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.setFoodLevel(20);
						all.setHealth(20);
					}
					Game.inStatup = true;
					time--;
					if (time  == 120) {
						Bukkit.broadcastMessage(message.prefix + "§c2 minutes§8 until the game starts!");
					} else if (time == 60) {
						Bukkit.broadcastMessage(message.prefix + "§c1 minute§8 until the game starts!");
					} else if (time == 30) {
						Bukkit.broadcastMessage(message.prefix + "§c30 seconds§8 until the game starts!");
					} else if (time <= 10) {
						Bukkit.broadcastMessage(message.prefix + "§c" + time + " seconds§8 until the game starts!");
					}
				} else if (Bukkit.getOnlinePlayers().size() >= clients) {
					//start Invi
					Game.inStatup = false;
					Game.startGame();
					Bukkit.getScheduler().cancelTask(countdown);
				} else {
					Bukkit.broadcastMessage(message.prefix + "§8There are not enough players to start the Game! There must be at least §c" + clients + " §8players to start the game!");
					YamlConfiguration cfg = BasicConfig.getConfiguration();
					startup.time = cfg.getInt("preGame");
				}
			}
		}, 0, 20);
	}
}
