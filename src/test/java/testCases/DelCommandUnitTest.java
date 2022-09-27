package testCases;

import command.CommandsExecutor;
import command.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelCommandUnitTest extends LineEditorUnitTests{
    @ParameterizedTest(name = "del {0}")
    @ValueSource(ints = {-1, 0, 3, 20, 100})
    void DelCommandTestEmptyFile(int rowNumber) throws InvalidCommandException, IOException {
        CommandsExecutor cmd = new CommandsExecutor(emptyFileBuffer);
        assertThrows(InvalidCommandException.class, ()-> cmd.executeCommand("del " + rowNumber));
    }
    @ParameterizedTest(name = "del {0}")
    @ValueSource(ints = {-1, 0, 3, 20, 100})
    void DelCommandTestNotEmptyFile(int rowNumber) throws InvalidCommandException, IOException {
        CommandsExecutor cmd = new CommandsExecutor(testFileBuffer);
        if ((rowNumber == -1)||(rowNumber == 0)||((rowNumber == 100))){
            assertThrows(InvalidCommandException.class, ()-> cmd.executeCommand("del " + rowNumber));
        }
        else{
            cmd.executeCommand("del " + rowNumber);
            testFile.remove(rowNumber - 1);
            assertEquals(testFile.toString(), testFileBuffer.getAsPlainTextLinkedList().toString());
        }
    }
}
