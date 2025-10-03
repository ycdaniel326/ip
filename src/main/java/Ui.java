import java.util.Scanner;

/**
 * Ui handles user input and displays messages.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new Ui instance.
     * Creates a scanner to read user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Shows welcome message to users in the beginning.
     */
    public void displayWelcomeMessage() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm YC");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________\n");
    }

    /**
     * Shows goodbye message to users when users exit the program.
     */
    public void displayByeMessage() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________\n");
    }

    /**
     * Reads the user input of command.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Shows error if unable to load the stored task list file.
     */
    public void showLoadingError() {
        System.out.println("\tError loading tasks file. Starting with an empty list.");
    }
}
