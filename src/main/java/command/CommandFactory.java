package command;

import buffer.TextBuffer;

public class CommandFactory{
    TextBuffer buffer;

    CommandFactory(TextBuffer buffer){
        this.buffer = buffer;
    }

    public Command createCommand (String command) throws InvalidCommandException{
        String[] enteredCommand = command.split(" ", 3);
        switch (enteredCommand[0]){
            case "list":
                return new ListTextCommand(buffer);
            case "del":
                try {
                    return new DeleteLineAtPositionCommand(buffer, Integer.parseInt(enteredCommand[1]));
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid number format. Please, try again.");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Need a line number. Please, try again.");
                }
                throw new InvalidCommandException("Invalid command exception");
            case "ins":
                try {
                    StringBuilder newLine = enteredCommand.length >=3 ? new StringBuilder(enteredCommand[2]) : new StringBuilder("");
                    return new InsertLineAtPositionCommand(buffer, Integer.parseInt(enteredCommand[1]), newLine);
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid number format. Please, try again.");
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Need a line number. Please, try again.");
                }
                throw new InvalidCommandException("Invalid command exception");
            case "save":
                return new SaveCommand(buffer);
            case "quit":
                return new QuitCommand(buffer);
            default:
                throw new InvalidCommandException("Invalid command exception");
        }
    }
}
