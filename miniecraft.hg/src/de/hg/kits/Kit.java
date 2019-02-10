package de.hg.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit {

	private static String name;
	private static ItemStack kitItem;
	private static ItemStack[] items;
	private static List<String> lore;
	private static ArrayList<Player> onKit;
	private static int tokens;
	
	public Kit(String name, ItemStack kitItem, ItemStack[] items, List<String> lore, ArrayList<Player> onKit, int tokens) {
		Kit.name = name;
		Kit.kitItem = kitItem;
		Kit.items = items;
		Kit.lore = lore;
		Kit.onKit = onKit;
		Kit.tokens = tokens;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the kitItem
	 */
	public ItemStack getKitItem() {
		return kitItem;
	}

	/**
	 * @param kitItem the kitItem to set
	 */
	public void setKitItem(ItemStack kitItem) {
		this.kitItem = kitItem;
	}

	/**
	 * @return the items
	 */
	public ItemStack[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ItemStack[] items) {
		this.items = items;
	}

	/**
	 * @return the lore
	 */
	public List<String> getLore() {
		return lore;
	}

	/**
	 * @param lore the lore to set
	 */
	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	/**
	 * @return the onKit
	 */
	public ArrayList<Player> getOnKit() {
		return onKit;
	}

	/**
	 * @param onKit the onKit to set
	 */
	public void setOnKit(ArrayList<Player> onKit) {
		this.onKit = onKit;
	}

	/**
	 * @return the tokens
	 */
	public int getTokens() {
		return tokens;
	}

	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(int tokens) {
		this.tokens = tokens;
	}
	
	
	
}
