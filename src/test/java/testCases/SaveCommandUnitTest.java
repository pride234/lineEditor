package testCases;

import command.CommandsExecutor;
import command.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveCommandUnitTest extends LineEditorUnitTests{
    @Test
    void SaveCommandTest() throws InvalidCommandException, IOException {
        emptyFile.clear();
        emptyFileBuffer.clear();
        BufferedWriter saver = new BufferedWriter(new FileWriter(emptyFileBuffer.getFilePath()));
        saver.append("");
        CommandsExecutor cmd = new CommandsExecutor(emptyFileBuffer);
        cmd.executeCommand("ins 5 Save to file test");
        cmd.executeCommand("save");
        Scanner reader = new Scanner(emptyFileFile);
        while (reader.hasNextLine())
            emptyFile.add(new StringBuilder(reader.nextLine()));
        reader.close();
        saver = new BufferedWriter(new FileWriter(emptyFileBuffer.getFilePath()));
        saver.append("");
        saver.close();
        assertEquals(emptyFileBuffer.getAsPlainTextLinkedList().toString(), emptyFile.toString());
        emptyFile.clear();
        emptyFileBuffer.clear();
    }
}
