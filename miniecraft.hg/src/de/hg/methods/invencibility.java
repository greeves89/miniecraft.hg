package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.hg.main.main;
import de.hg.utils.message;
import de.hg.worldgeneration.WorldGeneration;

public class invencibility {

	private static int countdown;
	public static int high;
	
	/**
	 * High is the amount of seconds the countdown will be counting
	 * @param high
	 */
	public static void startInvencibility() {
		World world = Bukkit.getWorld(WorldGeneration.worldname);
		if (world != null) {
			countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					if (high != 0) {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.setFoodLevel(20);
							all.setHealth(20);
						}
						high--;
						if (high == 60) {
							Bukkit.broadcastMessage(getRemainingTime());
						} else if (high == 30) {
							Bukkit.broadcastMessage(getRemainingTime());
						} else if (high == 15) {
							Bukkit.broadcastMessage(getRemainingTime());
						} else if (high <= 10) {
							if (high <= 5) {
								for (Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.ANVIL_LAND, 1, 10);
								}
							}
							Bukkit.broadcastMessage(getRemainingTime());
						}
					} else {
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.ENDERDRAGON_HIT, 1, 10);
						}
						Bukkit.broadcastMessage(message.prefix + "§8You are no longer invicible!!");
						high = 120;
						Game.didProCanJoin = false;
						endInvencibility();
						Bukkit.getScheduler().cancelTask(countdown);
					}
				}
			}, 0, 20);
		}
	}
	private static String getRemainingTime() {
		return message.prefix + "§8The inviciblity will end in §c" + high + "§8 seconds!";
	}
	private static void endInvencibility() {
		FeastAnnouncment.waitUntilAnnouncment();
		Game.inInvenciblity = false;
		Game.didProCanJoin = false;
		Game.didPlayerCanPvP = true;
	}
}
