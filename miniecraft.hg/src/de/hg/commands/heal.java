package de.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.methods.Gamer;
import de.hg.utils.message;

public class heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (Gamer.isPlayerInAdminMode(p)) {
				if (args.length == 0) {
					p.setFoodLevel(20);
					p.setFoodLevel(20);
					p.sendMessage("§2Du wurdest geheilt!");
				} else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (target == null) {
						p.sendMessage("§cDer Spieler " + args[0].toString() + " ist nicht online oder existiert nicht!");
					} else {
						target.setFoodLevel(20);
						target.setHealth(20);
						target.sendMessage(message.prefix+ "§2du wurdest geheilt!");
						p.sendMessage("§2Du hast den Spieler: " + target.getName() + " geheilt!");
					}
					
				}
			} else {
				if (p.hasPermission("server.admin")) {
					p.sendMessage("§cDu bist nicht im Adminmode!");
				}
			}
		} else {
			sender.sendMessage("You are not a Player and only Players can perform this command!");
		}
		
		return true;
	}

}
