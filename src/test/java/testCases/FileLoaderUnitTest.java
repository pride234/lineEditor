package testCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class FileLoaderUnitTest extends LineEditorUnitTests{
    @Test
    void FileLoaderTest() throws FileNotFoundException {
        String expected = testFile.toString();
        String actual = testFileBuffer.getAsPlainTextLinkedList().toString();
        Assertions.assertEquals(expected, actual);
        expected = emptyFile.toString();
        actual = emptyFileBuffer.getAsPlainTextLinkedList().toString();
        Assertions.assertEquals(expected, actual);
    }
}
