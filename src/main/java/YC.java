import java.util.Scanner;
public class YC {
    public static void main(String[] args) {
        String bot_Name = "YC";
        Scanner scanner = new Scanner(System.in);
        String userCommand;
        Task[] commandList = new Task[100];
        int totalCommands = 0;

        displayWelcomeMessage(bot_Name);

        while (true) {
            userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("bye")) {
                displayByeMessage();
                break;
            }
            if (userCommand.equalsIgnoreCase("list")) {
                System.out.println("\t" + "____________________________________________________________");
                for  (int i = 0; i < totalCommands; i++) {
                    System.out.println("\t" + (i+1) + ".[" + commandList[i].getStatusIcon() + "] " +
                            commandList[i].getDescription());
                }
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if (userCommand.toLowerCase().startsWith("mark")) {
                int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
                commandList[taskIndex].markAsDone();
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Nice! I've marked this task as done:");
                System.out.println("\t\t" + "[X] " + commandList[taskIndex].getDescription());
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if (userCommand.toLowerCase().startsWith("unmark")) {
                int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
                commandList[taskIndex].markAsNotDone();
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "OK, I've marked this task as not done yet:");
                System.out.println("\t\t" + "[ ] " + commandList[taskIndex].getDescription());
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else {
                commandList[totalCommands] = new Task(userCommand);
                totalCommands++;
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "added: " + userCommand);
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

        }
    }


    private static void displayWelcomeMessage(String bot_Name) {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Hello! I'm " + bot_Name);
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayByeMessage() {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }
}
