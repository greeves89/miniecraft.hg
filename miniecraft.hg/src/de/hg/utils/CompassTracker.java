package de.hg.utils;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.methods.Game;

public class CompassTracker implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Game.isRunning) {
			if (e.getMaterial() == Material.COMPASS) {
				Player target = getNearestPlayer(p);
				if (target != null) {
					int dis = (int) p.getLocation().distance(target.getLocation());
					p.sendMessage(message.prefix + "§2Dein Compass zeigt nun auf §c" + target.getName() + "! §2Er ist noch §c" + dis + " Blöcke §2entfernt!");
					p.setCompassTarget(target.getLocation());
				} else {
					p.sendMessage(message.prefix + "§cEs sind keine Spieler in deiner Nähe!");
				}
			}
		}
	}
	
	public static Player getNearestPlayer(Player p) {
		double distance = Double.MAX_VALUE;
		Player target = null;
		for (Entity entity : p.getNearbyEntities(300, 200, 300)) {
			if (entity instanceof Player) {
				double dis = p.getLocation().distance(entity.getLocation());
				
				if (dis < distance) {
					distance = dis;
					target = (Player) entity;
				}
			}
		}
		return target;
	}
	
	public static ItemStack getCompass() {
		ItemStack item = new ItemStack(Material.COMPASS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§cTracker");
		item.setItemMeta(meta);
		return item;
	}
	
}
