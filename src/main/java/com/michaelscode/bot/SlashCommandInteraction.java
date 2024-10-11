package com.michaelscode.bot;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

public class SlashCommandInteraction extends ListenerAdapter {
	JokeApi api;
	public SlashCommandInteraction(JokeApi api) {
		this.api = api;
	}

	@Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getGuild() == null) {
            return;
        }
        switch (event.getName()) {
            case "joke":
                joke(event);
                break;
            default:
            	event.reply("Sorry! that didnt work! :(").queue();
        }
    }

    public void joke(SlashCommandInteractionEvent event) {
    	String joke = api.getJoke();
    	event.reply(joke).queue();
    }
}
