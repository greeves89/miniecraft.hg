package de.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.methods.Game;
import de.hg.methods.startup;

public class startCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("hg.start")) {
			if (Bukkit.getOnlinePlayers().size() >= 1 && !Game.isRunning) {
				startup.time = 0;
				sender.sendMessage("§2You have started the game!");
			} else {
				sender.sendMessage("§cGame is already running or there are not enough players to start the game!");
			}
		}
		return true;
	}

}
