package de.hg.fileconfiguration;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import de.hg.listener.SoupHealing;
import de.hg.methods.Deathmatch;
import de.hg.methods.Feast;
import de.hg.methods.FeastAnnouncment;
import de.hg.methods.Game;
import de.hg.methods.GameCancel;
import de.hg.methods.invencibility;
import de.hg.methods.startup;
import de.hg.utils.CompassTracker;
import de.hg.utils.message;

public class BasicConfig {
	
	private static File getConfigFile() {
        return new File("plugins/HungerGames", "config.yml");
    }

    public static YamlConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        YamlConfiguration cfg = getConfiguration();
        cfg.options().copyDefaults(true); 
        
        cfg.addDefault("min_players", 1);
        cfg.addDefault("max_players", 24);
        cfg.addDefault("prefix", "&8[&6Hunger&2Games&8] ");
        cfg.addDefault("souphealing", false);
        cfg.addDefault("CompassRadius", 250);
        cfg.addDefault("FeastItemAmount", 25);
        
        cfg.addDefault("preGame", 120);
        cfg.addDefault("invincebility", 120);
        cfg.addDefault("FeastAnouncement", 360);
        cfg.addDefault("FeastCountdown", 120);
        cfg.addDefault("Pit", 300);
        cfg.addDefault("GameCancel", 120);
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        YamlConfiguration cfg = getConfiguration();	
        
        Game.minplayers = cfg.getInt("min_players");
        Game.maxplayers = cfg.getInt("max_players");
        SoupHealing.isEnabled = cfg.getBoolean("souphealing");
        CompassTracker.radius = cfg.getInt("CompassRadius");
        Feast.itemAmount = cfg.getInt("FeastItemAmount");
        
        invencibility.high = cfg.getInt("invincebility");
        startup.time = cfg.getInt("preGame");
        GameCancel.high = cfg.getInt("GameCancel");
        Deathmatch.high = cfg.getInt("Pit");
        FeastAnnouncment.high = cfg.getInt("FeastCountdown");
        FeastAnnouncment.waitingTime = cfg.getInt("FeastAnouncement");
        message.prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("prefix"));
    }
	
}
