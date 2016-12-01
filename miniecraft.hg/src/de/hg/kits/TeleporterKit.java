package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleporterKit {
	
	private static String name = "§c§lTeleporter";

	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.teleporter")) {
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
		lore.add("§8Teleport to every Location you want!");
		lore.add("§8You'll get 5 enderperl");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§cDISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = enderpearl.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		enderpearl.setItemMeta(meta);
		return enderpearl;
	}
	public static void setKit(Player p) {
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 5);
		
		p.getInventory().addItem(enderpearl);
	}
}
