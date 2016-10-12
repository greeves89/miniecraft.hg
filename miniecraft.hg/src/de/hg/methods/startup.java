package de.hg.methods;

import org.bukkit.Bukkit;

import de.hg.main.main;
import de.hg.utils.message;

public class startup {

	static int countdown;
	static int time = 40;
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
					Game.inStatup = true;
					time--;
					if (time  == 120) {
						Bukkit.broadcastMessage(message.prefix + "§8Noch §c2 Minuten§8 bis zum Start!");
					} else if (time == 60) {
						Bukkit.broadcastMessage(message.prefix + "§8Noch §c1 Minuten§8 bis zum Start!");
					} else if (time == 30) {
						Bukkit.broadcastMessage(message.prefix + "§8Noch §c30 Sekunden§8 bis zum Start!");
					} else if (time <= 10) {
						Bukkit.broadcastMessage(message.prefix + "§8Noch §c" + time + " Sekunden§8 bis zum Start!");
					}
				} else if (Bukkit.getOnlinePlayers().size() >= clients) {
					//start Invi
					Game.inStatup = false;
					Game.startGame();
					Bukkit.getScheduler().cancelTask(countdown);
				} else {
					Bukkit.broadcastMessage(message.prefix + "§8Es sind zu wenige Spieler auf dem Server! Es müssen mindestens §c" + clients + " §8Spieler auf dem Server sein!");
					startup.time = 180;
				}
			}
		}, 0, 20);
	}
}
