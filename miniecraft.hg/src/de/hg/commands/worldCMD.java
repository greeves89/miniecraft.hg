package de.hg.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.methods.EndGame;
import de.hg.methods.Feast;

public class worldCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				Feast.createFeast(Material.STAINED_CLAY, 8);
				EndGame.setPlayerWinner(p);
			} else {
				Feast.startCreatingItems(8);
			}
		}
		return true;
	}

}
