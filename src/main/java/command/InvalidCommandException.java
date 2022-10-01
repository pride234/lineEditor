package command;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String exceptionText){
        super(exceptionText);
    }
}
