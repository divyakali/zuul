package com.aethena.zuul;

import java.util.Arrays;

public class Parser {
	public static Command parseCommand(String commandStr) {
		commandStr = commandStr.toUpperCase();
		String[] commandWords = commandStr.split(" ");
		Command command = new Command();
		if (commandWords.length == 1) {
			if (commandWords[0].equals("QUIT")
					|| commandWords[0].equals("HELP")
					|| commandWords[0].equals("SHOW"))
				command = new Command(commandWords[0]);
		} else if (commandWords.length == 2) {
			if (commandWords[0].equals("GO")
					&& (Arrays.binarySearch(new String[] { "NORTH", "EAST",
							"WEST", "SOUTH" }, commandWords[1])) == 1)
				command = new Command(commandWords[0], commandWords[1]);
		}
		return command;
	}
}
