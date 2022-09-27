package buffer;

import java.io.File;
import java.io.FileNotFoundException;

public interface Buffer {
    void setFromFile(File file) throws FileNotFoundException;
    void clear();
}
