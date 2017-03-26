package io.github.thatsmusic99.logincheck;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncPlayerPreLoginEvents implements Listener {
	
	@EventHandler
	public void onPlayerJoinPreventionEvent(AsyncPlayerPreLoginEvent e) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.hasPermission("logincheck.notify")) {
				//
			}
		}
	}
	
	

}
