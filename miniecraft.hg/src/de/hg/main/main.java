package de.hg.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.hg.commands.BugCommand;
import de.hg.commands.adminCMD;
import de.hg.commands.gamemodeCMD;
import de.hg.commands.heal;
import de.hg.commands.hubCMD;
import de.hg.commands.moneyCMD;
import de.hg.commands.worldCMD;
import de.hg.kits.Fisherman;
import de.hg.kits.KitSelector;
import de.hg.kits.Soupmaster;
import de.hg.kits.Stomper;
import de.hg.kits.Switcher;
import de.hg.listener.ASyncChatManagment;
import de.hg.listener.MOTD;
import de.hg.listener.PlayerBreak;
import de.hg.listener.PlayerDeath;
import de.hg.listener.PlayerHitOtherPlayers;
import de.hg.listener.PlayerJoin;
import de.hg.listener.PlayerLeave;
import de.hg.methods.Feast;
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
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd remove 1");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "motd add JOIN");
		
		Feast.loc = Feast.getLocation();
		
		if (WorldGeneration.didWorldExist()) {
			startup.startGame(1);
			WorldGeneration.setWorldBoarder();
		} else {
			WorldGeneration.createWorld();
			startup.startGame(1);
		}
		
		startMySQL();
		
		
		Bukkit.getConsoleSender().sendMessage("[HungerGames] aktiviert!");
		
	}
	public void onDisable() {
		
		mysql.close();
		
		Bukkit.getConsoleSender().sendMessage("[HungerGames] deaktiviert!");
		
	}
	private void registerCommands() {
		this.getCommand("money").setExecutor(new moneyCMD());
		this.getCommand("world").setExecutor(new worldCMD());
		this.getCommand("hub").setExecutor(new hubCMD());
		this.getCommand("admin").setExecutor(new adminCMD());
		this.getCommand("gamemode").setExecutor(new gamemodeCMD());
		this.getCommand("heal").setExecutor(new heal());
		this.getCommand("bug").setExecutor(new BugCommand());
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
		pm.registerEvents(new MOTD(), this);
		pm.registerEvents(new ScoreboardClass(), this);
		pm.registerEvents(new JoinRegistration(), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Switcher(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new adminCMD(), this);
		pm.registerEvents(new DisplaynameSetup(), this);
		pm.registerEvents(new ASyncChatManagment(), this);
	}
	private static void startMySQL() {
		mysql.connect();
		mysql.createTable();
	}
	public static main getInstance() {
		return instance;
	}
}
