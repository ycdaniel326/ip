package exceptions;

/**
 * Thrown when the user is not entering a valid index.
 */
public class InvalidIndexException extends Exception {

    /**
     * Constructs the exception with the message.
     *
     * @param message The warning to show to user.
     */
    public InvalidIndexException(String message) {
        super(message);
    }
}
