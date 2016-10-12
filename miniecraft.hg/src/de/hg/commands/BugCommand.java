package de.hg.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.hg.utils.message;

public class BugCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§cCheck your Syntax: /bug <name_of_bug> <description>");
			} else if (args.length ==  1) {
				p.sendMessage("§cCheck your Syntax: /bug <name_of_bug> <description>");
			} else if (args.length >= 2) {
				String s = "";
				for (int i = 1; i < args.length; i++) {
					s = s + args[i] + " ";
				}
				addNewBug(args[0].toString(), s, p);
				p.sendMessage(message.prefix + "§cDein Bug wurde eingesendet! Missbrauch wird bestraft!");
			}
		}
		return true;
	}
	public static void addNewBug(String label, String description, Player p) {
		File path = new File("");
		File dir = new File(path.getAbsolutePath() + "/Bugs/");
		
		File file = new File(dir + "/" + label + " - " + p.getName() + ".txt");
		
		if (dir.mkdirs()) {
			System.out.println("The Bugs directory have been created!");
		}
		if (dir.exists()) {
			try {
				System.out.println("Bug File created: " + file.createNewFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String ispremium = "false";
		if (p.hasPermission("server.premium")) {
			ispremium = "true";
		}
		String ip = p.getAddress().toString();
		try {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(description);
		bw.newLine();
		bw.newLine();
		bw.write("Reporter: " + p.getName());
		bw.newLine();
		bw.write("Premium (or higher): " + ispremium); 
		bw.newLine();
		bw.write("IP Adress: " + ip);
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
