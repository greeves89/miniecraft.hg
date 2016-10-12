package de.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.hg.methods.Gamer;

public class adminCMD implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("server.admin")) {
				if(Gamer.isPlayerInAdminMode(p)) {
					Gamer.inAdminMode.remove(p);
					p.sendMessage(Gamer.adminPrefix + "§c you are no longer in admin mode!");
				} else {
					p.sendMessage(Gamer.adminPrefix + "§c you are in admin mode now!");
					Gamer.inAdminMode.add(p);
					for (Player all : Bukkit.getOnlinePlayers()) {
						if (!Gamer.inAdminMode.contains(all)) {
							all.hidePlayer(p);
						}
					}
					p.setGameMode(GameMode.CREATIVE);
				}
			}
		} else {
			sender.sendMessage("You can't perform this command!");
		}
		
		return true;
	}
}
