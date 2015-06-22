package com.aethena.zuul;

public class Command {
private String command;
private String second;

/**
 * 
 */
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
 * @param command the command to set
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
 * @param second the second to set
 */
public void setSecond(String second) {
	this.second = second;
}


}
