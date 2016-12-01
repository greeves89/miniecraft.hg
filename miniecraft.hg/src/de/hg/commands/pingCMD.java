package de.hg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EntityPlayer;

public class pingCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("hg.ping")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (cmd.getName().equalsIgnoreCase("ping")) {
					if (args.length == 0) {
						CraftPlayer pingc = (CraftPlayer) p;
						EntityPlayer pinge = pingc.getHandle();
						int ping = pinge.ping;
						p.sendMessage("§bYour Ping is §c" + ping + " ms");
					}
				}
			}
		}
		return true;
	}
}
