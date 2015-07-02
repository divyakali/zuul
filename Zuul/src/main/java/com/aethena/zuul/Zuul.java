package com.aethena.zuul;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is the main class of the "World of Zuul" application. To play this
 * game, create an instance of this class and call the "play" method. This main
 * class creates and initialises all the others: it creates all rooms, creates
 * the parser and starts the game. It also evaluates and executes the commands
 * that the parser returns.
 * 
 * @author aethena
 *
 */
public class Zuul {
	private Room hall, corridor, dining, kitchen, garden;
	private ArrayList<Room> bluePrint = new ArrayList<Room>();
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Zuul");
		Parser.showInstructions();
		Zuul app = new Zuul();
		app.initialize();
		app.play();
	}

	/**
	 * Initialize rooms
	 */
	private void initialize() {
	
		hall = new Room("Hallway", "This is the Entrance hallway.");
		corridor = new Room("Corridor", "You are in the corridor");
		dining = new Room("Dining", "This is the dining room.");
		kitchen = new Room("Kitchen", "This is the kitchen");
		garden = new Room("Garden",
				"Smell flowers? Yes, you are in the garden.");

		hall.addExit("SOUTH", corridor);
	
		corridor.addExit("SOUTH", dining);

		dining.addExit("WEST", kitchen);
		kitchen.addExit("EAST", dining);
		kitchen.addExit("SOUTH", garden);

		garden.addExit("NORTH", kitchen);
		
		bluePrint.add(hall);
		bluePrint.add(corridor);
		bluePrint.add(dining);
		bluePrint.add(kitchen);
		bluePrint.add(garden);

	}
	private void printLocation(Room room){
		System.out.println("Location: "+room.getRoomName()+"->"+room.getDescription());
	}
	
	private void play() {
		Scanner scanner = new Scanner(System.in);
		String commandStr;
		try{
		Room currentRoom = hall;
		while(true){
		printLocation(currentRoom);
		System.out.println("Enter a command:");
		commandStr = scanner.nextLine();
		Command command = Parser.parseCommand(commandStr);
		if(command.getSecond() == null)
			Parser.executeCommand(command);
		else
			currentRoom = Parser.executeCommand2(command,currentRoom);
		}
		}finally{
			scanner.close();
		}
	}
}
