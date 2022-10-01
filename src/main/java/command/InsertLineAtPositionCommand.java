package command;

import buffer.TextBuffer;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertLineAtPositionCommand implements Command{
    TextBuffer buffer;
    int position;
    StringBuilder newLine;

    InsertLineAtPositionCommand(TextBuffer buffer, int position, StringBuilder newLine){
        this.buffer = buffer;
        this.position = position - 1;
        this.newLine = newLine;
    }
    @Override
    public void execute() throws InvalidCommandException{
        LinkedList<StringBuilder> bufferList = buffer.getAsPlainTextLinkedList();
        if (position<0){
            throw new InvalidCommandException("Number must be more than 0.");
        }
        if (position>= bufferList.size())
            for (int i = bufferList.size(); i<position;i++)
                bufferList.add(i,new StringBuilder(""));
        Scanner userInput = new Scanner(System.in);
        if(newLine.toString().equals("")){
            System.out.println("Please, enter a new line to inset:");
            System.out.print(">> ");
            newLine = new StringBuilder(userInput.nextLine());
        }
        bufferList.add(position, newLine);
        buffer.setPlainTextField(bufferList);
        buffer.setIsSavedFlag(false);
    }
}
