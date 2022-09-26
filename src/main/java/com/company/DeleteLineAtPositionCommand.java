package com.company;

import java.util.LinkedList;

public class DeleteLineAtPositionCommand implements Command{
    TextBuffer buffer;
    int position;

    DeleteLineAtPositionCommand(TextBuffer buffer, int position){
        this.buffer = buffer;
        this.position = position;
    }
    @Override
    public void execute(){
        LinkedList<StringBuilder> bufferList = buffer.getAsPlainTextLinkedList();
        if (position<=0)
            System.out.println("Number must be more than 0.");
        else if (position>= bufferList.size())
            System.out.println("No such line in text.");
        else {
            bufferList.remove(position);
            buffer.setPlainTextField(bufferList);
            buffer.isSaved = false;
        }
    }
}
