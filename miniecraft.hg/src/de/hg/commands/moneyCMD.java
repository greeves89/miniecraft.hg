package de.hg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.mysql.moneymysql;
import de.hg.utils.message;

public class moneyCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(message.prefix + "§cDein Kontostand beträgt: " + moneymysql.getMoney(p.getUniqueId()) + message.currency);
		}
		
		return true;
	}
	
}
