package testCases;

import command.CommandsExecutor;
import command.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InsCommandUnitTest  extends LineEditorUnitTests{

    @ParameterizedTest(name = "ins {0}")
    @ValueSource(ints = {-1, 0, 1, 20, 100})
    void InsCommandTest(int rowNumber) throws InvalidCommandException, IOException {
        CommandsExecutor testCmd = new CommandsExecutor(testFileBuffer);
        CommandsExecutor emptyCmd = new CommandsExecutor(emptyFileBuffer);
        if ((rowNumber == -1)||(rowNumber == 0)){
            assertThrows(InvalidCommandException.class, ()-> testCmd.executeCommand("ins " + rowNumber));
            assertThrows(InvalidCommandException.class, ()-> emptyCmd.executeCommand("ins " + rowNumber));
        }
        else{
            StringBuilder newLine = new StringBuilder("New line for test");
            testCmd.executeCommand("ins " + rowNumber + " " + newLine);
            emptyCmd.executeCommand("ins " + rowNumber + " " + newLine);
            int rowNumberMinus = rowNumber - 1;
            if (rowNumberMinus>= testFile.size())
                for (int i = testFile.size(); i<rowNumberMinus;i++)
                    testFile.add(i,new StringBuilder(""));
            if (rowNumberMinus>= emptyFile.size())
                for (int i = emptyFile.size(); i<rowNumberMinus;i++)
                    emptyFile.add(i,new StringBuilder(""));
            testFile.add(rowNumberMinus, newLine);
            emptyFile.add(rowNumberMinus, newLine);
            assertEquals(testFile.toString(), testFileBuffer.getAsPlainTextLinkedList().toString());
            assertEquals(emptyFile.toString().trim(), emptyFileBuffer.getAsPlainTextLinkedList().toString());
        }
    }
}
