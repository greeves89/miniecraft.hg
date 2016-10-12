package de.hg.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.hg.kits.KitSelector;
import de.hg.methods.Game;
import de.hg.methods.Gamer;
import de.hg.utils.message;
import de.hg.worldgeneration.WorldGeneration;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Gamer.clear(p);
		
		p.setHealth(20);
		p.setFoodLevel(20);
		
		World spawn = Bukkit.getWorld(WorldGeneration.worldname);
		p.teleport(spawn.getSpawnLocation()); 
		
		if (Game.didPlayerCanJoin) {
			
			p.sendMessage(message.prefix + "du hast den Server betreten.");
			e.setJoinMessage(message.prefix + "der Spieler " + p.getName() + " ist dem Spiel beigetreten.");
			p.setGameMode(GameMode.ADVENTURE);
			Game.inGame.add(p);
			p.getInventory().setItem(4, KitSelector.getKitSelector());
			
		} else if (Game.didProCanJoin) {
			
			if (p.hasPermission("server.premium")) {
				p.setGameMode(GameMode.ADVENTURE);
				Game.inGame.add(p);
				p.sendMessage(message.prefix + "du hast den Server betreten!");
			} else {
				p.kickPlayer("§cDas Spiel läuft bereits! Kaufe §6Premium §cum trotzdem beitreten zu können!");
			}
			
		} else {
			p.kickPlayer("§cDas Spiel läuft bereits!");
		}
	}
}
