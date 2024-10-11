package com.michaelscode.bot;

public class Main {
	static DiscordAPI api;
	public static void main(String[] args) throws InterruptedException {
		try {
			api = new DiscordAPI();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
