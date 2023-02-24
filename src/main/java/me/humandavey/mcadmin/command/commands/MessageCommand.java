package me.humandavey.mcadmin.command.commands;

import me.humandavey.mcadmin.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageCommand extends Command {

	public MessageCommand() {
		super("message", "Message a player that is online!");

		addOptions(new OptionData(OptionType.STRING, "player", "The player to send a message to", true),
				new OptionData(OptionType.STRING, "message", "The message to send", true));
	}

	@Override
	public void execute(SlashCommandInteractionEvent event) {
		Player target = Bukkit.getPlayerExact(event.getOption("player").getAsString());
		if (target != null) {
			target.sendMessage(event.getOption("message").getAsString());
			event.reply("Message sent to " + target.getName() + "!").setEphemeral(true).queue();
			return;
		}
		event.reply("Message could not be sent!").setEphemeral(true).queue();
	}
}