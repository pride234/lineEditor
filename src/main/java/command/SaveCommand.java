package command;

import buffer.TextBuffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command{
    TextBuffer buffer;

    SaveCommand(TextBuffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void execute() {
        try {
            BufferedWriter saver = new BufferedWriter(new FileWriter(buffer.getFilePath()));
            saver.append("");
            StringBuilder strToSave = new StringBuilder("");
            for (StringBuilder str : buffer.getAsPlainTextLinkedList())
                strToSave.append(str).append(System.lineSeparator().toString());
            saver.append(strToSave);
            saver.close();
            buffer.setIsSavedFlag(true);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error with saving file. Return to main menu");
        }
    }
}
