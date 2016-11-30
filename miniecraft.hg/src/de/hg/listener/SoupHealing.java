package de.hg.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupHealing implements Listener {

	public static boolean isEnabled = false;
	
	public void onSoup(PlayerInteractEvent e) {
		if (isEnabled) {
			Player p = e.getPlayer();
			if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
				if (p.getHealth() == 20) {
					if (p.getFoodLevel() == 20) {
						e.setCancelled(true);
					} else if (p.getFoodLevel() == 13) {
						p.setFoodLevel(20);
						p.getItemInHand().setType(Material.BOWL);
					} else {
						p.setFoodLevel(p.getFoodLevel() + 7);
						p.getItemInHand().setType(Material.BOWL);
					}
				} else if (p.getHealth() >= 13) {
					p.setHealth(20);
					p.getItemInHand().setType(Material.BOWL);
				} else {
					p.setHealth(p.getHealth() + 7);
					p.getItemInHand().setType(Material.BOWL);
				}
			}
		}
	}
	
	
	
}
