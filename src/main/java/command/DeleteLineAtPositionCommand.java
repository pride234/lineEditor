package command;

import buffer.TextBuffer;

import java.util.LinkedList;

public class DeleteLineAtPositionCommand implements Command{
    TextBuffer buffer;
    int position;

    DeleteLineAtPositionCommand(TextBuffer buffer, int position){
        this.buffer = buffer;
        this.position = position - 1;
    }
    @Override
    public void execute() throws InvalidCommandException{
        LinkedList<StringBuilder> bufferList = buffer.getAsPlainTextLinkedList();
        if (position<=0){
            throw new InvalidCommandException("Number must be more than 0");
        }
        else if (position>= bufferList.size())
            throw new InvalidCommandException("No such line in text.");
        else {
            bufferList.remove(position);
            buffer.setPlainTextField(bufferList);
            buffer.setIsSavedFlag(false);
        }
    }
}
