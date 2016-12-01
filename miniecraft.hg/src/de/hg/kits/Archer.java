package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Archer {

	private static String name = "§e§lArcher";
	
	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.archer")) {
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
		lore.add("§8Shoot your enemies down!");
		lore.add("");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§cDISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		bow.setItemMeta(meta);
		return bow;
	}
	public static void setKit(Player p) {
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		p.getInventory().addItem(bow);
		p.getInventory().addItem(arrow);
	}
}
