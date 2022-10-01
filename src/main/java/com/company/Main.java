package com.company;

import buffer.PlainTextBuffer;
import buffer.TextBuffer;
import command.CommandsExecutor;
import command.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TextBuffer buffer = new PlainTextBuffer();
        try{
            File plainText = new File(args[0]);
            buffer.setFromFile(plainText);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("====Error! No file specified. Exiting the program...====");
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println("====Error! File not found. Exiting the program...====");
            System.exit(0);
        }
        CommandsExecutor cmd = new CommandsExecutor(buffer);
        Scanner userInput = new Scanner(System.in);
        String uInput;
        while (true){
            System.out.print(">> ");
            uInput = userInput.nextLine();
            try {
                cmd.executeCommand(uInput);
            }
            catch (InvalidCommandException e){
                System.out.println("Invalid command format. Please, try again");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IOException. Please, try again");
            }
        }
    }
}
