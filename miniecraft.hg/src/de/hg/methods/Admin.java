package de.hg.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Admin {

	public static void sendMessage(String msg) {
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (all.hasPermission("hg.admin.messenger")) {
				all.sendMessage("§4[Admin-Messager] " + msg);
			}
		}
	}
	
}
