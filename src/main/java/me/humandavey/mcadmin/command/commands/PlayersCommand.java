package me.humandavey.mcadmin.command.commands;

import me.humandavey.mcadmin.command.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayersCommand extends Command {

	public PlayersCommand() {
		super("list", "List all the online players");
	}

	@Override
	public void execute(SlashCommandInteractionEvent event) {
		EmbedBuilder b = new EmbedBuilder().setTitle("Online Players (" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");
		for (Player player : Bukkit.getOnlinePlayers()) {
			b.addField(player.getName(), "- " + player.getName(), false);
		}
		event.replyEmbeds(b.build()).queue();
	}
}
