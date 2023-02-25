package me.humandavey.mcadmin.command.commands;

import me.humandavey.mcadmin.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;

public class PlayersCommand extends Command {

	public PlayersCommand() {
		super("list", "List all the online players");
	}

	@Override
	public void execute(SlashCommandInteractionEvent event) {
		if (Bukkit.getOnlinePlayers().size() == 0) {
			event.reply("There are no players online!").queue();
			return;
		}

		EmbedBuilder b = new EmbedBuilder()
				.setTitle("Online Players (" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")")
				.setColor(new Color(30, 150, 50));
		for (Player player : Bukkit.getOnlinePlayers()) {
			b.addField(player.getName(), "- " + player.getName(), false);
		}
		event.replyEmbeds(b.build()).queue();
	}
}
