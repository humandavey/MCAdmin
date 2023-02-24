package me.humandavey.mcadmin;

import me.humandavey.mcadmin.command.commands.ExecuteCommand;
import me.humandavey.mcadmin.command.commands.PlayersCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCAdmin extends JavaPlugin {

	private static JDA jda;
	private static MCAdmin instance;

	@Override
	public void onEnable() {
		instance = this;
		try {
			jda = JDABuilder.createDefault("MTA3ODQ4OTk4NDEyMzgwOTgyMg.GgS-L9.AyuqLskVaGo3YWM6ztv3Y4BbErcsBihhKcEtRI")
					.setActivity(Activity.watching("over your server..."))
					.addEventListeners(new ExecuteCommand(), new PlayersCommand())
					.build();
			jda.awaitReady();
		} catch (InterruptedException e) {
			getLogger().severe("There was an error loading the discord bot! Disabling MCAdmin...");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		getLogger().info("Discord bot sucessfully started!");
	}

	@Override
	public void onDisable() {
		jda.shutdown();
	}

	public static JDA getJDA() {
		return jda;
	}

	public static MCAdmin getInstance() {
		return instance;
	}
}
