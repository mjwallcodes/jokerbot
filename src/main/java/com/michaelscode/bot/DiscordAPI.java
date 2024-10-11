package com.michaelscode.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public class DiscordAPI extends ListenerAdapter{
	static JokeApi api = new JokeApi();
	public DiscordAPI() throws Exception {
		JDA jda = JDABuilder.createDefault(System.getenv("DISCORD_KEY"))
		.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES)
		.addEventListeners(new MessageReceivedListener(api), new SlashCommandInteraction(api)).build();
		CommandListUpdateAction commands = jda.updateCommands();
		commands.addCommands(
			Commands.slash("joke", "Tells a joke.")
		);
		commands.queue();
    }
	
}
