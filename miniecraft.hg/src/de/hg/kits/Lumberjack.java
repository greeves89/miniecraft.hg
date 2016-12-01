package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Lumberjack {
	
	private static String name = "§e§lLumberjack";
	
	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.lumberjack")) {
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
		lore.add("§eCut trees faster than every other!");
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
		ItemStack pick = new ItemStack(Material.WOOD_AXE);
		ItemMeta meta = pick.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		pick.setItemMeta(meta);
		return pick;
	}
	public static void setKit(Player p) {
		ItemStack axe = new ItemStack(Material.WOOD_AXE);
		axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
		axe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		p.getInventory().addItem(axe);
	}
}
