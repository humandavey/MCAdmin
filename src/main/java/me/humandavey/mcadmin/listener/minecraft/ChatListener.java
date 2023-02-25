package me.humandavey.mcadmin.listener.minecraft;

import me.humandavey.mcadmin.MCAdmin;
import me.humandavey.mcadmin.config.Config;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		TextChannel c = Config.getChatChannel();

		c.sendMessage(event.getPlayer().getName() + ": " + event.getMessage()).queue();
	}
}
