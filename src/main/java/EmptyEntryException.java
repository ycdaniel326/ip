public class EmptyEntryException extends Exception {

    public EmptyEntryException() {
        super("The task entry is empty!");
    }
}
