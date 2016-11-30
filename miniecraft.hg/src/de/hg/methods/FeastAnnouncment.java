package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import de.hg.main.main;

public class FeastAnnouncment {

	private static int time;
	public static int high;
	
	private static int waiting;
	public static int waitingTime;
	
	public static void waitUntilAnnouncment() {
		
		waiting = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if (waitingTime != 0) {
					waitingTime--;
				} else {
					startFeastAnnouncment();
					Bukkit.getScheduler().cancelTask(waiting);
				}
				
			}
		}, 0, 20);
		
	}
	
	public static void startFeastAnnouncment() {
		
		Feast.createFeast(Material.GRASS, 12);
		Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
		
		time = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				if (high != 0) {
					high--;
					if (high == 180) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in 3 Minuten!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 120) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in 2 Minuten!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 60) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in 1 Minute!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 30) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in 30 Sekunden!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 10) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in 10 Sekunden!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high < 10) {
						Bukkit.broadcastMessage("§cDas Feast beginnt in " + high + " Sekunden!");
					}
				} else {
					Bukkit.broadcastMessage("§cDas Feast ist erschienen!");
					Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					Feast.startCreatingItems(10);
					Game.isFeast = false;
					Deathmatch.startPitCountdown();
					Bukkit.getScheduler().cancelTask(time);
				}
				
			}
			
		}, 0, 20);
	}
	
	
}
