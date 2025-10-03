import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm YC");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________\n");
    }

    public void displayByeMessage() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________\n");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showLoadingError() {
        System.out.println("\tError loading tasks file. Starting with an empty list.");
    }
}
