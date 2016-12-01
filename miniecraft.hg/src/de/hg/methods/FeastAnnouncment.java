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
						Bukkit.broadcastMessage("§cThe Feast start's in 3 minutes!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 120) {
						Bukkit.broadcastMessage("§cThe Feast start's in 2 minutes!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 60) {
						Bukkit.broadcastMessage("§cThe Feast start's in 1 minute!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 30) {
						Bukkit.broadcastMessage("§cThe Feast start's in 30 seconds!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high == 10) {
						Bukkit.broadcastMessage("§cThe Feast start's in 10 seconds!");
						Bukkit.broadcastMessage("§cFeast: X: " + Feast.loc.getBlockX() + " Y: " + Feast.loc.getBlockY() + " Z: " + Feast.loc.getBlockZ());
					} else if (high < 10) {
						Bukkit.broadcastMessage("§cThe Feast start's in " + high + " seconds!");
					}
				} else {
					Bukkit.broadcastMessage("§cThe Feast spawned!");
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
