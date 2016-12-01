package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pyro {
	
	private static String name = "§c§lPyro";
	
	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.pyro")) {
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
		lore.add("§cBurn everything down!");
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
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta meta = lava.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		lava.setItemMeta(meta);
		return lava;
	}
	public static void setKit(Player p) {
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		
		ItemStack fas = new ItemStack(Material.FLINT_AND_STEEL, 2);
		
		ItemStack water = new ItemStack(Material.WATER_BUCKET);
		
		p.getInventory().addItem(water);
		p.getInventory().addItem(lava);
		p.getInventory().addItem(fas);
	}
}
