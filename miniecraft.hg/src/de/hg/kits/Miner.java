package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Miner {
	
	private static String name = "§e§lMiner";
	
	private static boolean isFree = false;
	public static int price = 250;

	public static boolean checkBuy(Player p) {
		if (isFree) {
			return true;
		} else if (p.hasPermission("kits.miner")) {
			return true;
		} else {
			return false;
		}
	}
	
 	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§8Du erhälst eine Diamantspitzhacke!");
		lore.add("§8Farme dir Items und werde stärker	");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2gekauft");
		} else {
			lore.add("§cnicht gekauft");
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
