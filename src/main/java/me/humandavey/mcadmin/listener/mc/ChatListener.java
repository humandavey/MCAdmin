package me.humandavey.mcadmin.listener.mc;

import me.humandavey.mcadmin.MCAdmin;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		TextChannel c = MCAdmin.getInstance().getJDA().getGuildById(MCAdmin.getInstance().getConfig().getLong("guild-id"))
				.getTextChannelById(MCAdmin.getInstance().getConfig().getLong("chat-channel-id"));

		c.sendMessage(event.getPlayer().getName() + ": " + event.getMessage()).queue();
	}
}
