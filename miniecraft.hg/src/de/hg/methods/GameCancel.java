package de.hg.methods;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.hg.main.main;
import de.hg.utils.message;

public class GameCancel {

	private static int countdown;
	public static int high;
	
	public static void startCancleCountdown() {
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if (high != 0) {
					if (high == 60) {
						Bukkit.broadcastMessage(message.prefix + "§cDas Spiel wird in einer Minute abgebrochen!");
					} else if (high <= 10) {
						Bukkit.broadcastMessage(message.prefix + "§cDas Spiel wird in " + high + " Sekunden abgebrochen!");
					}
					high--;
				} else {
					Random rn = new Random();
					Player winner =  Game.inGame.get(rn.nextInt(Game.inGame.size()));
					for (int i = 0; i < Game.inGame.size(); i++) {
						Player current = Game.inGame.get(i);
						if (current.getUniqueId().equals(winner.getUniqueId())) {
							EndGame.setPlayerWinner(winner);
						} else {
							current.kickPlayer("§cEs wurde ein zufälliger Winner gesucht.");
						}
					}
					Bukkit.getScheduler().cancelTask(countdown);
				}
				
			}
		}, 0, 20);
	}
	
}
