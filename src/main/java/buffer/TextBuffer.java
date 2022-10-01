package buffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public abstract class TextBuffer implements Buffer{
    LinkedList<StringBuilder> buffer = null;
    String filePath;
    boolean isSaved = true;

    public StringBuilder getAsPlainTextString() {
        return new StringBuilder(buffer.toString());
    }
    public LinkedList<StringBuilder> getAsPlainTextLinkedList() {
        return buffer;
    }
    public boolean getIsSavedFlag (){
        return isSaved;
    }
    public void setIsSavedFlag (boolean flag){
        this.isSaved = flag;
    }
    public String getFilePath(){
        return filePath;
    }
    abstract public void setFromFile (File file) throws FileNotFoundException;
    abstract public void setPlainTextField (LinkedList<StringBuilder> buffer);
    abstract public void clear();
 }
