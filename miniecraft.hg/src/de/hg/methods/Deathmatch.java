package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.hg.main.main;
import de.hg.utils.message;


public class Deathmatch {

	private static int countdown;
	private static int high = 5*60;
	
	public static void teleportAllPlayerToPit() {
		Location pit = new Location(Bukkit.getWorld("pit"), 3, 5, 11);
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.teleport(pit);
		}
	}
	public static void startPitCountdown() {
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if (high != 0) {
					if (high == 60) {
						Bukkit.broadcastMessage(message.prefix + "§cdas Deathmatch startet in einer Minute!");
					} else if (high <= 10) {
						Bukkit.broadcastMessage(message.prefix + "§cDas Deathmatch beginnt in " + high + " Sekunden!");
					}
					high--;
				} else {
					Game.inpit = true;
					GameCancel.startCancleCountdown();
					teleportAllPlayerToPit();
					Bukkit.getScheduler().cancelTask(countdown);
				}
			}
		}, 0, 20);
	}
	
}
