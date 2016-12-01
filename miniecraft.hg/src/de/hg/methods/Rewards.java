package de.hg.methods;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Rewards {

	//not used now
	
	private static ArrayList<ItemStack> rewards = new ArrayList<>();
	
	private static ItemStack getReward() {
		addRewards();
		Random rn = new Random();
		int index = rn.nextInt(rewards.size());
		return rewards.get(index);
	}
	public static void addRewards() {
		ItemStack diamondsword = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack diamondchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack ironpickaxe = new ItemStack(Material.IRON_PICKAXE);
		ItemStack diamonds = new ItemStack(Material.DIAMOND, 7);
		ItemStack diamond = new ItemStack(Material.DIAMOND);
		ItemStack iron = new ItemStack(Material.IRON_INGOT, 37);
		ItemStack ironhelmet = new ItemStack(Material.IRON_HELMET);
		ItemStack diamondpickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemStack goldingot = new ItemStack(Material.GOLD_INGOT, 12);
		
		rewards.add(diamondpickaxe);
		rewards.add(diamondpickaxe);
		rewards.add(diamondsword);
		rewards.add(diamondchestplate);
		rewards.add(ironpickaxe);
		rewards.add(ironpickaxe);
		rewards.add(ironpickaxe);
		rewards.add(diamonds);
		rewards.add(diamond);
		rewards.add(diamond);
		rewards.add(diamond);
		rewards.add(iron);
		rewards.add(iron);
		rewards.add(ironhelmet);
		rewards.add(ironhelmet);
		rewards.add(ironhelmet);
		rewards.add(ironhelmet);
		rewards.add(goldingot);
		rewards.add(goldingot);
	}
}
