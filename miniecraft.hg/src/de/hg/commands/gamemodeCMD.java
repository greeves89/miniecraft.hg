package de.hg.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.methods.Gamer;

public class gamemodeCMD implements CommandExecutor {

	private static void sendGameModeMessage(Player p) {
		if (p.getGameMode() == GameMode.ADVENTURE) {
			p.sendMessage("§cDu bist nun im Adventuremodus!");
		} else if (p.getGameMode() == GameMode.CREATIVE) {
			p.sendMessage("§cDu bist nun im Kreativmodus!");
		} else if (p.getGameMode() == GameMode.SURVIVAL) {
			p.sendMessage("§cDu bist nun im Überlebensmodus!");
		} else if (p.getGameMode() == GameMode.SPECTATOR) {
			p.sendMessage("§cDu bist nun im Zuschauermodus!");
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (Gamer.isPlayerInAdminMode(p)) {
				if (args.length == 0) {
					if (p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SPECTATOR)) {
						p.setGameMode(GameMode.CREATIVE);
						sendGameModeMessage(p);
					} else  if (p.getGameMode().equals(GameMode.CREATIVE)){
						p.setGameMode(GameMode.SURVIVAL);
						sendGameModeMessage(p);
					}
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						sendGameModeMessage(p);
					} else if (args[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						sendGameModeMessage(p);
					} else if (args[0].equalsIgnoreCase("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						sendGameModeMessage(p);
					} else if (args[0].equalsIgnoreCase("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						sendGameModeMessage(p);
					} else {
						p.sendMessage("/gamemode <gamemode> (player)");
					}
				} else if (args.length == 2) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target == null) {
						p.sendMessage("§cDer Spieler §2" + args[1].toString() + "§c ist nicht online oder existiert nicht!");
					}
					if (args[0].equalsIgnoreCase("0")) {
						target.setGameMode(GameMode.SURVIVAL);
						sendGameModeMessage(target);
						p.sendMessage("§2Du hast den Spielmpdus von §2" + target.getName() + " geändert");
					} else if (args[0].equalsIgnoreCase("1")) {
						target.setGameMode(GameMode.CREATIVE);
						sendGameModeMessage(target);
						p.sendMessage("§2Du hast den Spielmpdus von §2" + target.getName() + " geändert");
					} else if (args[0].equalsIgnoreCase("2")) {
						target.setGameMode(GameMode.ADVENTURE);
						sendGameModeMessage(target);
						p.sendMessage("§2Du hast den Spielmpdus von §2" + target.getName() + " geändert");
					} else if (args[0].equalsIgnoreCase("3")) {
						target.setGameMode(GameMode.SPECTATOR);
						sendGameModeMessage(target);
						p.sendMessage("§2Du hast den Spielmpdus von §2" + target.getName() + " geändert");
					} else {
						p.sendMessage("/gamemode <gamemode> (player)");
					}
				} else {
					p.sendMessage("/gamemode <gamemode> (player)");
				}
			} else {
				if (p.hasPermission("server.admin")) {
					p.sendMessage("§cDu bist nicht im Adminmode!");
				}
			}
		} else {
			sender.sendMessage("You can't do that!");
		}
		
		return false;
	}
}
