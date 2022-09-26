package com.company;

import java.io.IOException;
import java.util.Scanner;

public class CommandFactory{
    TextBuffer buffer;

    CommandFactory(TextBuffer buffer){
        this.buffer = buffer;
    }

    public Command createCommand (String command) throws InvalidCommandException{
        if (command.equals("list")){
            return new ListTextCommand(buffer);
        }
        else if(command.contains("del")){
            String[] str = command.split(" ");
            if (str[0].equals("del")){
                try {
                    return new DeleteLineAtPositionCommand(buffer, Integer.parseInt(str[1]) - 1);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                    System.out.println("Invalid number format. Please, try again.");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("Need a line number. Please, try again.");
                }
            }
            throw new InvalidCommandException("Invalid command exception");
        }
        else if (command.contains("ins")){
            String[] str = command.split(" ");
            if (str[0].equals("ins")){
                try {
                    return new InsertLineAtPositionCommand(buffer, Integer.parseInt(str[1]) - 1, new StringBuilder(""));
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                    System.out.println("Invalid number format. Please, try again.");
                    throw new InvalidCommandException("Invalid command exception");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("Need a line number. Please, try again.");
                    throw new InvalidCommandException("Invalid command exception");
                }
            }
            throw new InvalidCommandException("Invalid command exception");
        }
        else if(command.equals("save")){
            return new SaveCommand(buffer);
        }
        else if (command.equals("quit")){
            return new QuitCommand(buffer);
        }
        else{
            throw new InvalidCommandException("Invalid command exception");
        }
    }
}
