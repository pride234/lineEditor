package command;

import buffer.TextBuffer;

import java.io.IOException;

public class CommandsExecutor{
    private TextBuffer buffer;
    private CommandFactory cF;

    public CommandsExecutor(TextBuffer buffer){
        this.cF = new CommandFactory(buffer);
        this.buffer = buffer;
    }
    public void executeCommand(String command) throws InvalidCommandException, IOException {
        Command commandToExecute = cF.createCommand(command);
        commandToExecute.execute();
    }
}
