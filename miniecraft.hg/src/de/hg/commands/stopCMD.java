package de.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class stopCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("hg.stop")) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				p.kickPlayer("§cThe server has been stopped!");
			}
			Bukkit.getConsoleSender().sendMessage("§4§lThe server has been stopped by " + sender.getName() + "!");
			Bukkit.getServer().reload();
		}
		
		return true;
	}

}
