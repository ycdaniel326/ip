package exceptions;

/**
 * Thrown when the user is not entering the command in a valid format.
 */
public class InvalidFormatException extends Exception {

    /**
     * Constructs the exception with the message.
     *
     * @param message The warning to show to user.
     */
    public InvalidFormatException(String message) {
        super(message);
    }
}
