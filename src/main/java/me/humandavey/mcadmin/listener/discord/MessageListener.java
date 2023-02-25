package me.humandavey.mcadmin.listener.discord;

import me.humandavey.mcadmin.MCAdmin;
import me.humandavey.mcadmin.config.Config;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(@NotNull MessageReceivedEvent event) {
		if (event.getChannel().asTextChannel() == Config.getChatChannel()) {
			new BukkitRunnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("<" + event.getMember().getUser().getName() + "> " + event.getMessage().getContentDisplay());
				}
			}.runTaskLater(MCAdmin.getInstance(), 0L);
		}
	}
}
