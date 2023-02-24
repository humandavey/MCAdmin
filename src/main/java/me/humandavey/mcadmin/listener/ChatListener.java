package me.humandavey.mcadmin.listener;

import me.humandavey.mcadmin.MCAdmin;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	private final JDA jda = MCAdmin.getInstance().getJDA();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		TextChannel c = jda.getGuildById(MCAdmin.getInstance().getConfig().getLong("guild-id"))
				.getTextChannelById(MCAdmin.getInstance().getConfig().getLong("chat-channel-id"));

		c.sendMessage(event.getPlayer().getName() + ": " + event.getMessage()).queue();
	}
}
