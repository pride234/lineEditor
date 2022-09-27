package testCases;

import buffer.PlainTextBuffer;
import buffer.TextBuffer;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class LineEditorUnitTests {
    LinkedList<StringBuilder> testFile = new LinkedList<>();;
    LinkedList<StringBuilder> emptyFile = new LinkedList<>();;
    TextBuffer testFileBuffer = new PlainTextBuffer();
    TextBuffer emptyFileBuffer = new PlainTextBuffer();
    File testFileFile = new File("src\\main\\resources\\testFile.txt");
    File emptyFileFile = new File("src\\main\\resources\\emptyFile.txt");
    protected final PrintStream standardOut = System.out;
    protected final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void reset(){
        try {
            testFileBuffer.setFromFile(testFileFile);
            emptyFileBuffer.setFromFile(emptyFileFile);
            Scanner testFileReader = new Scanner(testFileFile);;
            Scanner emptyFileReader = new Scanner(emptyFileFile);;
            while (testFileReader.hasNextLine())
                testFile.add(new StringBuilder(testFileReader.nextLine()));
            while (emptyFileReader.hasNextLine())
                emptyFile.add(new StringBuilder(emptyFileReader.nextLine()));
            testFileReader.close();
            emptyFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
