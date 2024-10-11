package com.michaelscode.bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceivedListener extends ListenerAdapter {
	JokeApi api; 
	public MessageReceivedListener(JokeApi api) {
		// TODO Auto-generated constructor stub
		this.api = api;
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if(e.getAuthor().isBot()) return;
		Message m = e.getMessage();
		String c = m.getContentRaw();
		if (c.equals("!joke")) {
			MessageChannel channel = e.getChannel();
			channel.sendMessage(api.getJoke()).queue();
		}
	}	
}
