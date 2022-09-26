package com.company;

import java.util.LinkedList;

public class ListTextCommand implements Command{
    TextBuffer buffer;

    public ListTextCommand(TextBuffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void execute() throws InvalidCommandException{
        LinkedList<StringBuilder> bufferList = buffer.getAsPlainTextLinkedList();
        if (bufferList.size() <= 0)
            return;
        int i = 0;
        for (; i < bufferList.size()-1; i++) {
            System.out.println((i+1)+":"+ bufferList.get(i));
        }
        System.out.println((i+1)+":"+ bufferList.get(i));
    }
}
