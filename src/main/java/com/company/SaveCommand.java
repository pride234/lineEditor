package com.company;

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
            BufferedWriter saver = new BufferedWriter(new FileWriter(buffer.filePath));
            saver.append(buffer.getAsPlainTextString());
            saver.close();
            buffer.isSaved = true;
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error with saving file. Return to main menu");
        }
    }
}
