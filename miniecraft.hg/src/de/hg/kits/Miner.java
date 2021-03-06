package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Miner {
	
	private static String name = "�e�lMiner";

	public static boolean isEnabled;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.miner")) {
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
		lore.add("�eYou will get a OP pickaxe and some torches!");
		lore.add("");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("�2owned");
		} else {
			lore.add("�cDISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = pickaxe.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		pickaxe.setItemMeta(meta);
		return pickaxe;
	}
	public static void setKit(Player p) {
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		
		pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
		pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 2);
		
		ItemStack torch = new ItemStack(Material.TORCH, 64);
		ItemStack cookies = new ItemStack(Material.COOKIE, 16);
		
		p.getInventory().addItem(pickaxe);
		p.getInventory().addItem(torch);
		p.getInventory().addItem(cookies);
	}
}
