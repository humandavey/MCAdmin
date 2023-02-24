package me.humandavey.mcadmin.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public abstract class Command extends ListenerAdapter {

	private final String name;
	private final SlashCommandData command;

	public Command(final String name, final String description) {
		this.name = name;

		this.command = Commands.slash(name, description);
	}

	public final void addOption(OptionType type, String name, String description) {
		command.addOption(type, name, description);
	}

	public final void addOption(OptionType type, String name, String description, boolean required) {
		command.addOption(type, name, description, required);
	}

	public final void addOptions(OptionData... data) {
		command.addOptions(data);
	}

	@Override
	public final void onReady(ReadyEvent event) {
		event.getJDA().updateCommands().addCommands(command).queue();
	}

	@Override
	public final void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		if (event.getName().equals(name)) {
			execute(event);
		}
	}

	public abstract void execute(SlashCommandInteractionEvent event);
}
