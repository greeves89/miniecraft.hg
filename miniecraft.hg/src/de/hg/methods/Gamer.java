package de.hg.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Gamer {

	public static ArrayList<Player> inAdminMode = new ArrayList<>();
	public static String adminPrefix = "§8[§cAdminMode§8]";
	
	
	public static void healGamers() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.setHealth(20);
			all.setFoodLevel(20);
		}
	}
	public static void clear(Player p) {
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		p.setLevel(0);
	}
	public static boolean isPlayerInAdminMode(Player p) {
		if (inAdminMode.contains(p) && p.hasPermission("server.admin")) {
			return true;
		} else {
			return false;
		}
	}
	
}
