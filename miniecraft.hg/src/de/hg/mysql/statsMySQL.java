package de.hg.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.entity.Player;

public class statsMySQL {

	public static boolean didPlayerExist(UUID uuid) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM HGStats WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void insertUser(UUID uuid, Player p) {
		if(!didPlayerExist(uuid)) {
			try {
				PreparedStatement ps = mysql.getConnection().prepareStatement("INSERT INTO HGStats (Playername,UUID,Kills,Deaths,Wins) VALUES (?,?,?,?,?)");
				ps.setString(1, p.getName());
				ps.setString(2, uuid.toString());
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void updateWin(UUID uuid, boolean add, int amount) {
		int current = getWins(uuid);
		if (add) {
			current = current + amount;
		} else {
			current = current - amount;
		}
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE HGStats SET Wins = ? WHERE UUID = ?");
			ps.setInt(1, current);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void updateKills(UUID uuid, boolean add, int amount) {
		int current = getKills(uuid);
		if (add) {
			current = current + amount;
		} else {
			current = current - amount;
		}
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE HGStats SET Kills = ? WHERE UUID = ?");
			ps.setInt(1, current);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateDeaths(UUID uuid, boolean add, int amount) {
		int current = getDeaths(uuid);
		if (add) {
			current = current + amount;
		} else {
			current = current - amount;
		}
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE HGStats SET Deaths = ? WHERE UUID = ?");
			ps.setInt(1, current);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Integer getWins(UUID uuid) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Wins FROM HGStats WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("Wins");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static Integer getKills(UUID uuid) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Kills FROM HGStats WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("Kills");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static Integer getDeaths(UUID uuid) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT Deaths FROM HGStats WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("Deaths");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
