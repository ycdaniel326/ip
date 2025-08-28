import java.util.Scanner;
public class YC {
    public static void main(String[] args) {
        String bot_Name = "YC";
        Scanner scanner = new Scanner(System.in);
        String userCommand;

        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Hello! I'm " + bot_Name);
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + "____________________________________________________________" + "\n");

        while (true) {
            userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("bye")) {
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Bye. Hope to see you again soon!");
                System.out.println("\t" + "____________________________________________________________" + "\n");
                break;
            }
            System.out.println("\t" + "____________________________________________________________");
            System.out.println("\t" + userCommand + "\n");
            System.out.println("\t" + "____________________________________________________________" + "\n");

        }
    }
}
