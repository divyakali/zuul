package com.aethena.zuul;

/**
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map"). The way this is used is: Commands are
 * already checked for being valid command words. If the user entered an
 * invalid command (a word that is not known) then the command word is
 * <null>. If the command had only one word, then the second word is <null>.
 * @author aethena
 */
public class Command {
	private String command;
	private String second;

	public Command() {

	}

	/**
	 * @param command
	 */
	public Command(String command) {
		this.setCommand(command);
	}

	/**
	 * @param command
	 * @param second
	 */
	public Command(String command, String second) {
		super();
		this.setCommand(command);
		this.setSecond(second);
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the second
	 */
	public String getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(String second) {
		this.second = second;
	}

}
