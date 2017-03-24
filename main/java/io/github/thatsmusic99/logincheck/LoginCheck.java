package io.github.thatsmusic99.logincheck;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginCheck extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getLogger().log(Level.INFO, "LoginCheck enabled.");
	}
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "LoginCheck disabled.");
	}

}
