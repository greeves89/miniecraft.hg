package de.hg.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class mysql {

	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	private static Connection con;
	
	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				Bukkit.getConsoleSender().sendMessage("[MySQL] zur Datenbank verbunden!");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	public static void close() {
		if (isConnected()) {
			try {
				con.close();
				Bukkit.getConsoleSender().sendMessage("[MySQL] Verbindung zur Datenbank getrennt!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	public static Connection getConnection() {
		return con;
	}
	public static void createTable() {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS HGStats (Playername VARCHAR(100),UUID VARCHAR(100),Kills INT(100),Deaths INT(100),Wins INT(100))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

