package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mage {
	
	private static String name = "§c§lMagier";

	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.mage")) {
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
		lore.add("§cDu bekommst einen Verzauberungstisch und 32 Lapislazuli");
		lore.add("");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack enchanter = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemMeta meta = enchanter.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		enchanter.setItemMeta(meta);
		return enchanter;
	}
	public static void setKit(Player p) {
		ItemStack enchanter = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK, 4);
		
		p.getInventory().addItem(enchanter);
		p.getInventory().addItem(lapis);
	}
}
