package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.hg.main.main;
import de.hg.utils.message;


public class Deathmatch {

	private static int countdown;
	public static int high;
	
	public static void teleportAllPlayersTogether() {
		Player p = null;
		for (Player temp : Bukkit.getOnlinePlayers()) {
			p = temp;
		}
		for (Player temp : Bukkit.getOnlinePlayers()) {
			temp.teleport(p.getLocation());
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
					teleportAllPlayersTogether();
					Bukkit.getScheduler().cancelTask(countdown);
				}
			}
		}, 0, 20);
	}
	
}
