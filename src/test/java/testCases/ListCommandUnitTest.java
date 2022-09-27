package testCases;

import command.CommandsExecutor;
import command.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;

public class ListCommandUnitTest extends LineEditorUnitTests {
    @Test
    void ListCommandTestNotEmptyFile() throws IOException, InvalidCommandException {
        PrintStream pS = new PrintStream(outputStreamCaptor);
        System.setOut(pS);
        String expected = new String("");
        int i = 0;
        for (; i < testFile.size()-1; i++) {
            expected += (i+1) + ":" + testFile.get(i) + System.lineSeparator();
        }
        expected += (i+1) + ":" + testFile.get(i);
        CommandsExecutor cmd = new CommandsExecutor(testFileBuffer);
        cmd.executeCommand("list");
        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
        System.setOut(standardOut);
        pS.close();
        Assertions.assertEquals(expected, actual);
        outputStreamCaptor.close();
        pS.close();
    }
    @Test
    void ListCommandTestEmptyFile() throws IOException, InvalidCommandException {
        PrintStream pS = new PrintStream(outputStreamCaptor);
        System.setOut(pS);
        String expected = new String("");
        CommandsExecutor cmd = new CommandsExecutor(emptyFileBuffer);
        cmd.executeCommand("list");
        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
        outputStreamCaptor.close();
        pS.close();
    }
}
