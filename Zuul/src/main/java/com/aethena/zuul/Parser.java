package com.aethena.zuul;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and tries
 * to interpret the line as a two word command. It returns the command as an
 * object of class Command. The parser has a set of known command words. It
 * checks user input against the known commands, and if the input is not one of
 * the known commands, it returns a command object that is marked as an un known
 * command.
 * 
 * @author aethena
 *
 */
public class Parser {
	private static String[] directions = new String[] { "NORTH", "EAST",
			"WEST", "SOUTH" };

	public static Command parseCommand(String commandStr) {
		commandStr = commandStr.toUpperCase();
		String[] commandWords = commandStr.split(" ");
		Command command = new Command();
		Arrays.sort(directions);
		if (commandWords.length == 1) {
			if (commandWords[0].equals("QUIT")
					|| commandWords[0].equals("HELP")
					|| commandWords[0].equals("SHOW"))
				command = new Command(commandWords[0]);
		} else if (commandWords.length == 2) {
			if (commandWords[0].equals("GO")
					&& (Arrays.binarySearch(directions, commandWords[1])>-1))
				command = new Command(commandWords[0], commandWords[1]);
		}
		return command;
	}

	public static void executeCommand(Command command) {

		if (command.getCommand().equals("QUIT"))
			System.exit(0);
		else if (command.getCommand().equals("SHOW"))
			showInstructions();
		else if (command.getCommand().equals("HELP"))
			System.out.print("You can Quit,Show,help or go somewhere");
		System.out.println("This is an invalid command");

	}

	public static void executeCommand2(Command command, Room currentRoom) {
		HashMap<String,Room> map = currentRoom.getExits();
		if(!command.getCommand().equals("GO")){
			System.out.println("This is not a valid command");
			
		}
		else{
			if(map.containsKey(command.getSecond()))
				currentRoom= map.get(command.getSecond());
			else
				System.out.println("No such direction");
		}
	}
	
	
	public static void showInstructions(){
		System.out.println("Commands Avaiable: HELP, QUIT, GO <Somewhere>. \n"
				+ "Direction available are:NORTH,EAST,WEST,SOUTH.");
	}
}
