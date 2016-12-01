package de.hg.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import de.hg.mysql.statsMySQL;

public class ScoreboardClass implements Listener {

	int sched;
	public static String website;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		updateScoreboard(p);
	}
	
	@SuppressWarnings("deprecation")
	public static void updateScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		
		obj.setDisplayName("§2§lHunger§6Games");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		int kills = statsMySQL.getKills(p.getUniqueId());
		int deaths = statsMySQL.getDeaths(p.getUniqueId());
		
		Score five = obj.getScore(Bukkit.getOfflinePlayer("§6Player: " + p.getName()));
		Score four = obj.getScore(Bukkit.getOfflinePlayer("§cKills: " + kills));
		Score three = obj.getScore(Bukkit.getOfflinePlayer("§cDeaths: " + deaths));
		Score two = obj.getScore(Bukkit.getOfflinePlayer("§eWebsite/TS:"));
		Score one = obj.getScore(Bukkit.getOfflinePlayer("§e" + website));
		
		five.setScore(5);
		four.setScore(4);
		three.setScore(3);
		two.setScore(2);
		one.setScore(1);
		
		p.setScoreboard(board);
	}
	
}
