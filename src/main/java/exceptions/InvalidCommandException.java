package exceptions;

/**
 * Thrown when the user is not entering a valid command.
 */
public class InvalidCommandException extends Exception {

    /**
     * Constructs the exception with the message.
     *
     * @param message The warning to show to user.
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
