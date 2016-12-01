package de.hg.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.hg.methods.Game;

public class PlayerHitOtherPlayers implements Listener {
	
	@EventHandler
	public void onPlayerHit (EntityDamageByEntityEvent e) {
		if (!Game.isRunning) {
			e.setCancelled(true);
		}
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
//			Player damager = (Player) e.getDamager();
//			Player victom = (Player) e.getEntity();
			if (!Game.didPlayerCanPvP) {
				e.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void EntityDamage(EntityDamageEvent e) {
		if (Game.inInvenciblity || Game.endgame) {
			if (e.getEntity() instanceof Player) {
				e.setCancelled(true);
			} 
		}
		if (Game.inStatup) {
			
			e.setCancelled(true);
			
		}
	}
	@EventHandler
	public void onCreeper(EntityExplodeEvent e) {
		if (Game.inStatup) {
			e.setYield(0.0F);
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onItemTake(PlayerPickupItemEvent e) {
		if (Game.inStatup) {
			e.setCancelled(true);
		}
	}
}
