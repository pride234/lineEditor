package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public abstract class TextBuffer implements Buffer{
    LinkedList<StringBuilder> buffer = null;
    String filePath;
    boolean isSaved = true;

    public StringBuilder getAsPlainTextString() {
        StringBuilder allText = new StringBuilder("");
        int i = 0;
        for (; i < buffer.size()-1; i++) {
            allText.append((buffer.get(i)+"\n"));
        }
        allText.append(buffer.get(i));
        return allText;
    }
    public LinkedList<StringBuilder> getAsPlainTextLinkedList() {
        return buffer;
    }
    abstract public void setFromFile (File file) throws FileNotFoundException;
    abstract public void setPlainTextField (LinkedList<StringBuilder> buffer);
    abstract public void clear();
 }
