package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertLineAtPositionCommand implements Command{
    TextBuffer buffer;
    int position;
    StringBuilder newLine;

    InsertLineAtPositionCommand(TextBuffer buffer, int position, StringBuilder newLine){
        this.buffer = buffer;
        this.position = position;
        this.newLine = newLine;
    }
    @Override
    public void execute(){
        LinkedList<StringBuilder> bufferList = buffer.getAsPlainTextLinkedList();
        if (position<0){
            System.out.println("Number must be more than 0.");
            return;
        }
        if (position>= bufferList.size())
            for (int i = bufferList.size(); i<position;i++)
                bufferList.add(i,new StringBuilder(""));
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please, enter a new line to inset:");
        System.out.print(">> ");
        newLine = new StringBuilder(userInput.nextLine());
        //userInput.close();
        bufferList.add(position, newLine);
        buffer.setPlainTextField(bufferList);
        buffer.isSaved = false;
    }
}
