package de.hg.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.hg.commands.pingCMD;
import de.hg.commands.startCMD;
import de.hg.commands.stopCMD;
import de.hg.fileconfiguration.FileConfigManagment;
import de.hg.kits.Fisherman;
import de.hg.kits.Kangaroo;
import de.hg.kits.KitSelector;
import de.hg.kits.Soupmaster;
import de.hg.kits.Stomper;
import de.hg.kits.Switcher;
import de.hg.listener.ASyncChatManagment;
import de.hg.listener.PlayerBreak;
import de.hg.listener.PlayerDeath;
import de.hg.listener.PlayerHitOtherPlayers;
import de.hg.listener.PlayerJoin;
import de.hg.listener.PlayerLeave;
import de.hg.listener.SoupHealing;
import de.hg.methods.Feast;
import de.hg.methods.Game;
import de.hg.methods.startup;
import de.hg.mysql.JoinRegistration;
import de.hg.mysql.mysql;
import de.hg.utils.CompassTracker;
import de.hg.utils.DisplaynameSetup;
import de.hg.utils.ScoreboardClass;
import de.hg.worldgeneration.PlayerJoinWhileWorldIsGenerating;
import de.hg.worldgeneration.WorldGeneration;

public class main extends JavaPlugin {

	private static main instance;
	
	public void onEnable() {
		instance = this;
		registerCommands();
		registerEvents();
		
		FileConfigManagment.loadConfigs();
		
		Feast.loc = Feast.getLocation();
		
		if (WorldGeneration.didWorldExist()) {
			WorldGeneration.setWorldBoarder();
		} else {
			WorldGeneration.createWorld();
		}
		
		startup.startGame(Game.minplayers);
		
		startMySQL();
		
		
		Bukkit.getConsoleSender().sendMessage("[HungerGames] enabled!");
		
	}
	public void onDisable() {
		
		mysql.close();
		
		Bukkit.getConsoleSender().sendMessage("[HungerGames] disabled!");
		
	}
	private void registerCommands() {

		this.getCommand("start").setExecutor(new startCMD());
		this.getCommand("ping").setExecutor(new pingCMD());
		this.getCommand("stop").setExecutor(new stopCMD());
	}
	private void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new KitSelector(), this);
		pm.registerEvents(new PlayerLeave(), this);
		pm.registerEvents(new PlayerHitOtherPlayers(), this);
		pm.registerEvents(new PlayerJoinWhileWorldIsGenerating(), this);
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new PlayerBreak(), this);
		pm.registerEvents(new Soupmaster(), this);
		pm.registerEvents(new CompassTracker(), this);
		pm.registerEvents(new ScoreboardClass(), this);
		pm.registerEvents(new JoinRegistration(), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Switcher(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new DisplaynameSetup(), this);
		pm.registerEvents(new ASyncChatManagment(), this);
		pm.registerEvents(new SoupHealing(), this);
		pm.registerEvents(new Kangaroo(), this);
	}
	private static void startMySQL() {
		mysql.connect();
		mysql.createTable();
	}
	public static main getInstance() {
		return instance;
	}
}
