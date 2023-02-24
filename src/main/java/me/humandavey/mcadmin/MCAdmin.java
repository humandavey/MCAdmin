package me.humandavey.mcadmin;

import me.humandavey.mcadmin.command.commands.ExecuteCommand;
import me.humandavey.mcadmin.command.commands.PlayersCommand;
import me.humandavey.mcadmin.config.Config;
import me.humandavey.mcadmin.listener.discord.MessageListener;
import me.humandavey.mcadmin.listener.mc.ChatListener;
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

		getLogger().info("---------------------[MCAdmin]---------------------");
		try {
			jda = JDABuilder.createDefault("MTA3ODQ4OTk4NDEyMzgwOTgyMg.GgS-L9.AyuqLskVaGo3YWM6ztv3Y4BbErcsBihhKcEtRI")
					.setActivity(Activity.watching("over your server..."))
					.addEventListeners(new ExecuteCommand(), new PlayersCommand(), new MessageListener())
					.build();
			jda.awaitReady();
		} catch (InterruptedException e) {
			getLogger().severe("There was an error loading the discord bot! Disabling MCAdmin...");
			getLogger().info("---------------------[MCAdmin]---------------------");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		getLogger().info("Sucessfully started discord bot!");

		getConfig().options().copyDefaults();
		saveDefaultConfig();
		getLogger().info("Sucessfully loaded config!");

		if (Config.isGuildValid()) {
			getLogger().severe("Invalid guild id! Please make sure it is up to date.");
			getLogger().info("---------------------[MCAdmin]---------------------");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		if (Config.isChatChannelEnabled()) {
			getServer().getPluginManager().registerEvents(new ChatListener(), this);
		}
		getLogger().info("Sucessfully registered events!");

		getLogger().info("---------------------[MCAdmin]---------------------");
	}

	@Override
	public void onDisable() {
		jda.shutdown();
	}

	public JDA getJDA() {
		return jda;
	}

	public static MCAdmin getInstance() {
		return instance;
	}
}
