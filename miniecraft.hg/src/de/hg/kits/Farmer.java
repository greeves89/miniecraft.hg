package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Farmer {
	private static String name = "§e§lFarmer";
	
	private static boolean isFree = true;
	public static int price = 150;

	public static boolean checkBuy(Player p) {
		if (isFree) {
			return true;
		} else if (p.hasPermission("kits.farmer")) {
			return true;
		} else {
			return false;
		}
	}

 	public static List<String> getDescription(Player p) {
		List<String> lore = new ArrayList<>();
		lore.add("§8Sorge für eine sichere Lebensmittelversorgung!");
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
		ItemStack bread = new ItemStack(Material.BREAD);
		ItemMeta meta = bread.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		bread.setItemMeta(meta);
		return bread;
	}
	public static void setKit(Player p) {
		ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
		
		ItemStack seeds = new ItemStack(Material.SEEDS, 64);
		ItemStack melonseeds = new ItemStack(Material.MELON_SEEDS, 32);
		ItemStack bucket = new ItemStack(Material.WATER_BUCKET);
		
		ItemStack bone = new ItemStack(Material.BONE, 32);
		
			p.getInventory().addItem(hoe);
			p.getInventory().addItem(seeds);
			p.getInventory().addItem(melonseeds);
			p.getInventory().addItem(bone);
			p.getInventory().addItem(bucket);
	}
}
