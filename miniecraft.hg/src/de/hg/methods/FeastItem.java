package de.hg.methods;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FeastItem {

	private static ArrayList<ItemStack> items = new ArrayList<>();
	
	public static void generateItems() {
		ItemStack diamondsword = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack diamondchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack diamondleggins = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack diamonds = new ItemStack(Material.DIAMOND, 7);
		ItemStack diamond = new ItemStack(Material.DIAMOND);
		ItemStack iron = new ItemStack(Material.IRON_INGOT, 37);
		ItemStack diamondhelmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack diamondpickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemStack goldingot = new ItemStack(Material.GOLD_INGOT, 12);
		
		items.add(diamondpickaxe);
		items.add(goldingot);
		items.add(diamondhelmet);
		items.add(diamondsword);
		items.add(diamondleggins);
		items.add(diamonds);
		items.add(diamond);
		items.add(iron);
		items.add(diamondchestplate);
	}
	public static ItemStack getItem() {
		Random rn = new Random();
		int index = rn.nextInt(items.size());
		return items.get(index);
	}
	
}
