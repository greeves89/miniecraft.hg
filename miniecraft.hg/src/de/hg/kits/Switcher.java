package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.kits.Kits.kits;

public class Switcher implements Listener {
	
	private static String name = "§c§lSwitcher";

	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.switcher")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

 	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§cDu bekommst 8 Schneebälle!");
		lore.add("§eWerfe diese auf deine Gegener um eure Positionen zu tauschen.");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack snowball = new ItemStack(Material.SNOW_BALL);
		ItemMeta meta = snowball.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		snowball.setItemMeta(meta);
		return snowball;
	}
	public static void setKit(Player p) {
		ItemStack snowball = new ItemStack(Material.SNOW_BALL, 8);
		
		p.getInventory().addItem(snowball);
	}
	@EventHandler
	public void onSnowballLaunch(EntityDamageByEntityEvent e) {
		if (e.getCause() == DamageCause.PROJECTILE) {
			if (e.getEntity() instanceof Snowball) {
				Player p = (Player) e.getDamager();
				if (KitSelector.kitHash.containsKey(p)) {
					if (KitSelector.kitHash.get(e) == kits.SWITCHER) {
						if (e.getDamager().getType() == EntityType.SNOWBALL) {
							if (e.getEntity() instanceof LivingEntity) {
								Location victomloc = e.getEntity().getLocation();
								Location PlayerLoc = p.getLocation();
								e.getEntity().teleport(PlayerLoc);
								p.teleport(victomloc);
							}
						}
					}
				}
			}
		}
	}
	
}
