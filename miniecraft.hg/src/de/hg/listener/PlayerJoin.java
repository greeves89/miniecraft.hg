package de.hg.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.hg.kits.KitSelector;
import de.hg.main.main;
import de.hg.methods.Game;
import de.hg.methods.Gamer;
import de.hg.utils.message;
import de.hg.worldgeneration.WorldGeneration;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Gamer.clear(p);
		
		p.setHealth(20);
		p.setFoodLevel(20);
		
		World spawn = Bukkit.getWorld(WorldGeneration.worldname);
		p.teleport(spawn.getSpawnLocation()); 
		System.out.println(spawn.getSpawnLocation().getY());
		
		if (Game.didPlayerCanJoin) {
			
			if (Bukkit.getOnlinePlayers().size() < Game.maxplayers) {
				e.setJoinMessage(message.prefix + p.getName() + "§2 join't the server!");
				p.setGameMode(GameMode.ADVENTURE);
				Game.inGame.add(p);
				p.getInventory().setItem(4, KitSelector.getKitSelector());
			} else {
				p.kickPlayer("§6The server in already full!");
			}
			
		} else if (Game.didProCanJoin) {
			
			if (p.hasPermission("hg.join.running")) {
				p.setGameMode(GameMode.ADVENTURE);
				Game.inGame.add(p);
				p.sendMessage(message.prefix + "you join't the server!");
			} else {
				p.kickPlayer("§cThe game is already running!");
			}
			
		} else {
			Bukkit.getScheduler().runTaskAsynchronously(main.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					p.kickPlayer("§6Game is already running!");
				}
			});
		}
	}
}
