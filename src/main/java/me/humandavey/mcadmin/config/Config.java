package me.humandavey.mcadmin.config;

import me.humandavey.mcadmin.MCAdmin;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

	private static final FileConfiguration config = MCAdmin.getInstance().getConfig();

	public static String getToken() {
		return config.getString("bot-token");
	}

	public static Guild getGuild() {
		return MCAdmin.getInstance().getJDA().getGuildById(config.getLong("guild-id"));
	}

	public static TextChannel getChatChannel() {
		return MCAdmin.getInstance().getJDA().getTextChannelById(config.getLong("chat-channel-id"));
	}

	public static TextChannel getLogChannel() {
		return MCAdmin.getInstance().getJDA().getTextChannelById(config.getLong("log-channel-id"));
	}

	public static boolean isGuildValid() {
		return getGuild() != null;
	}

	public static boolean isChatChannelValid() {
		return getChatChannel() != null;
	}

	public static boolean isLogChannelValid() {
		return getLogChannel() != null;
	}

	public static boolean isChatChannelEnabled() {
		return isChatChannelValid() && config.getLong("chat-channel-id") != -1;
	}

	public static boolean isLogChannelEnabled() {
		return isLogChannelValid() && config.getLong("log-channel-id") != -1;
	}
}
