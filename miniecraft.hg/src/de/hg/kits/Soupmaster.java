package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.hg.kits.Kits.kits;

public class Soupmaster implements Listener {

	private static String name = "§e§cSoupmaster";
	
	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.soupmaster")) {
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
		lore.add("§2You will get some soups!");
		lore.add("§cSoups will heal 2 of your hearts");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§cDISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta meta = soup.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		soup.setItemMeta(meta);
		return soup;
	}
	public static void setKit(Player p) {
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		for (int i = 0; i < 5; i++) {
			p.getInventory().addItem(soup);
		}
	}
	@EventHandler
	public void onSoup (PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
			if (KitSelector.kitHash.get(p).equals(kits.SOUPMASTER)) {
				if (p.getHealth() == 20) {
					if (p.getFoodLevel() == 20) {
						e.setCancelled(true);
					} else if (p.getFoodLevel() == 16) {
						p.setFoodLevel(20);
						p.getItemInHand().setType(Material.BOWL);
					} else {
						p.setFoodLevel(p.getFoodLevel() + 4);
						p.getItemInHand().setType(Material.BOWL);
						}
				} else if (p.getHealth() >= 16) {
					p.setHealth(20);
					p.getItemInHand().setType(Material.BOWL);
				} else {
					p.setHealth(p.getHealth() + 4);
					p.getItemInHand().setType(Material.BOWL);
				}
					
			}
		}
	}
	
}
