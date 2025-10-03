package exceptions;

/**
 * Thrown when the user is not entering the required description of the command.
 */
public class EmptyEntryException extends Exception {

    /**
     * Constructs the exception with the message.
     */
    public EmptyEntryException() {
        super("The task entry is empty!");
    }
}
