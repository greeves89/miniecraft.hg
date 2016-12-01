package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Grandpa {

	private static String name = "§c§lGrandpa";

	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.grandpa")) {
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
		lore.add("§cYou get a Knockback Stick!");
		lore.add("§cPunch anybody away!");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§4DISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack stick = new ItemStack(Material.STICK);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		ItemMeta meta = stick.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		stick.setItemMeta(meta);
		return stick;
	}
	public static void setKit(Player p) {
		ItemStack stick = new ItemStack(Material.STICK);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		p.getInventory().addItem(stick);
	}
	
}
