package de.hg.worldgeneration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.World.Environment;
import org.bukkit.WorldBorder;

import de.hg.methods.Admin;
import de.hg.methods.Game;

public class WorldGeneration implements Listener {

	public static String worldname = "hg_world";
	public static int bordersize = 500;
	
	public static boolean didWorldExist() {
		World world = Bukkit.getWorld(worldname);
		if (world != null) {
			return true;
		} else {
			return false;
		}
	}
	public static void createWorld() {
		if (!didWorldExist()) {
			WorldCreator creator = new WorldCreator(worldname);
			creator.environment(Environment.NORMAL);
			Bukkit.getServer().createWorld(creator);
			Game.didPlayerCanJoin = true;
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + worldname + " normal");
		} else {
			Admin.sendMessage("§cEin Error ist beim erstellen der HG Welt aufgetreten!");
			System.out.println("A massive Error occoured while Generating the world!");
			Game.didPlayerCanJoin = true;
			deleteWorld();
		}
	}
	public static void deleteWorld() {
		if (didWorldExist()) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete " + worldname);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
		}
	}
	public static void teleportToSpawn() {
		
		World world = Bukkit.getWorld(worldname);
		Location loc = world.getSpawnLocation();
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.teleport(loc);
		}
	}
	public static void setWorldBoarder() {
		World world = Bukkit.getWorld(worldname);
		
		WorldBorder boarder = world.getWorldBorder();
		boarder.setSize(bordersize);
		boarder.setWarningDistance(5);
		
	}
	
}
