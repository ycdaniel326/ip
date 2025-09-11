public class EmptyEntryException extends Exception {

    public EmptyEntryException() {
        super("The command entry is empty!");
    }
}
