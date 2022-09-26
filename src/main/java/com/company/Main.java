package com.company;

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
            e.printStackTrace();
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println("====Error! File not found. Exiting the program...====");
            e.printStackTrace();
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
                e.printStackTrace();
                System.out.println("No such command. Please, try again");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException. Please, try again");
            }
        }
    }
}
