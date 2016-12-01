package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Scout {
	
	private static String name = "§c§lScout";

	public static boolean isEnabled;
	
	public static int bottleAmount = 3;
	
	public static boolean checkBuy(Player p) {
		if (isEnabled) {
			if (p.hasPermission("hg.kit.scout")) {
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
		lore.add("§cPerfect Kit to run away!");
		lore.add("§cYou will have " + bottleAmount + " Speed Potions!");
		lore.add("");
		if (checkBuy(p)) {
			lore.add("§2owned");
		} else {
			lore.add("§4DISABLED");
		}
		return lore;
	}
	public static ItemStack getKitItem(Player p) {
		Potion pot = new Potion(PotionType.SPEED);
		ItemStack potion = new ItemStack(Material.POTION);
		pot.apply(potion);
		ItemMeta meta = potion.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(getDescription(p));
		potion.setItemMeta(meta);
		return potion;
	}
	public static void setKit(Player p) {
		Potion pot = new Potion(PotionType.SPEED);
		ItemStack potion = new ItemStack(Material.POTION, bottleAmount);
		pot.apply(potion);
		p.getInventory().addItem(potion);
	}
	
}
