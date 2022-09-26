package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PlainTextBuffer extends TextBuffer{

    PlainTextBuffer(){
        buffer = new LinkedList<>();
    }
    @Override
    public void setFromFile(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()) {
            buffer.add(new StringBuilder(fileReader.nextLine()));
        }
        fileReader.close();
        filePath = file.getPath();
    }
    @Override
    public void setPlainTextField(LinkedList<StringBuilder> buffer){
        this.buffer = buffer;
    }
    @Override
    public void clear(){
        buffer.clear();
    }
}
