package command;

import buffer.TextBuffer;

import java.util.Scanner;

public class QuitCommand implements Command{
    TextBuffer buffer;

    QuitCommand(TextBuffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void execute(){
        if(!buffer.getIsSavedFlag()){
            System.out.println("Are you sure you want to quit without saving? Any changes will be lost. Y/N");
            System.out.print(">> ");
            Scanner userInput = new Scanner(System.in);
            String uInput;
            uInput = userInput.nextLine();
            switch (uInput){
                case "Y":
                case "y":
                    break;
                case "N":
                case "n":
                    return;
                default:
                    System.out.println("No valid input, default is 'no'. Returning to the main menu...");
                    return;
            }
        }
        System.out.println("I was nice to see you, bye!");
        buffer.clear();
        System.exit(0);
    }
}
