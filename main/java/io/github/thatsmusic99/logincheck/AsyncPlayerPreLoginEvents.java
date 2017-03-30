package io.github.thatsmusic99.logincheck;

import java.net.InetAddress;

import mkremins.fanciful.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import static org.bukkit.ChatColor.*;

public class AsyncPlayerPreLoginEvents implements Listener {
	
	@EventHandler
	public void onPlayerJoinPreventionEvent(AsyncPlayerPreLoginEvent e) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (e.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) {
			    if (player.hasPermission("logincheck.notify")) {
				    player.sendMessage(warn(e.getName(), e.getAddress(), e.getLoginResult(), e.getKickMessage()));
			    }
			}
	    }
	}
	static String warn(String pn, InetAddress ip, AsyncPlayerPreLoginEvent.Result result, String reason) {
		String resultS = null;
		
		if (result == AsyncPlayerPreLoginEvent.Result.KICK_BANNED) {
			resultS = "Banned";
		}
		if (result == AsyncPlayerPreLoginEvent.Result.KICK_FULL) {
			resultS = "Server is full";
		}
		if (result == AsyncPlayerPreLoginEvent.Result.KICK_OTHER) {
			resultS = "Undefined";
		}
		if (result == AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST) {
			resultS = "Whitelist is enabled";
		}
		if (result == null) {
			resultS = "<null>";
		}
		return new FancyMessage("")
				.then(pn + " tried to log in, but was denied! Hover for more!")
				.color(RED)
				.tooltip(ChatColor.BLUE + "IP Address: " + ChatColor.AQUA + ip.toString() + ChatColor.BLUE + "\nReason: " + ChatColor.AQUA + resultS + ChatColor.BLUE + "\nMessage: " + ChatColor.AQUA + reason)
				.toJSONString();
	}
	
	
	

}
