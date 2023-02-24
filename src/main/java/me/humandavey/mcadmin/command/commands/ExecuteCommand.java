package me.humandavey.mcadmin.command.commands;

import me.humandavey.mcadmin.MCAdmin;
import me.humandavey.mcadmin.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ExecuteCommand extends Command {

	public ExecuteCommand() {
		super("executecommand", "Execute a command on your Minecraft server!");

		addOption(OptionType.STRING, "command", "The command to execute", true);
	}

	@Override
	public void execute(SlashCommandInteractionEvent event) {
		event.reply("Successfully executed command!").setEphemeral(true).queue();

		new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), event.getOption("command").getAsString());
			}
		}.runTaskLater(MCAdmin.getInstance(), 0L);
	}
}
