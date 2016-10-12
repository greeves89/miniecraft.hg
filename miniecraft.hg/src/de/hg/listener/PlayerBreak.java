package de.hg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.hg.methods.Feast;
import de.hg.methods.Game;

public class PlayerBreak implements Listener {

	@EventHandler
	public void onPlaceInInvencibility(BlockPlaceEvent e) {
		if (Game.inStatup) {
			e.setCancelled(true);
		}
		
		if(Game.isFeast) {
			if (Feast.checkIfLocationContainsFeast(e.getBlockPlaced().getLocation(), 12)) {
				e.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onBreakInInvencibility(BlockBreakEvent e) {
		if (Game.inStatup) {
			e.getPlayer().sendMessage("§cDu kannst während der Startphase nichts abbauen!");
			e.setCancelled(true);
		}
		if(Game.isFeast) {
			if (Feast.checkIfLocationContainsFeast(e.getBlock().getLocation(), 12)) {
				e.setCancelled(true);
			}
		}
	}
}
