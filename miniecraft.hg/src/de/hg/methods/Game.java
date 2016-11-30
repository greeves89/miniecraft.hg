package de.hg.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import de.hg.kits.KitSelector;
import de.hg.utils.CompassTracker;
import de.hg.utils.message;
import de.hg.worldgeneration.WorldGeneration;

public class Game {
//TODO:
	public static ArrayList<Player> inGame = new ArrayList<>();
	
	public static int maxplayers;
	public static int minplayers;
	
	public static boolean inpit = false;
	public static boolean didPlayerCanJoin = true;
	public static boolean inInvenciblity = false;
	public static boolean isRunning = false;
	public static boolean inStatup = false;
	public static boolean isFull = false;
	public static boolean didProCanJoin = false;
	public static boolean didPlayerCanPvP = false;
	public static boolean isFeast = false;
	public static boolean endgame = false;
	
	public static void startGame() {
		didProCanJoin = true;
		inInvenciblity = true;
		Bukkit.broadcastMessage(message.prefix + "§4Das Spiel wurde gestartet!");
		Bukkit.broadcastMessage(message.prefix + "Die Unverwundbarkeit hat begonnen!");
		WorldGeneration.teleportToSpawn();
		didPlayerCanJoin = false;
		isRunning = true;
		invencibility.startInvencibility();
		for (Player all : Bukkit.getOnlinePlayers()) {
			Gamer.clear(all);
			all.getInventory().addItem(CompassTracker.getCompass());
			all.setGameMode(GameMode.SURVIVAL);
			Gamer.healGamers();
		}
		KitSelector.setKit();
	}
	
}
