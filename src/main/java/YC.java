import java.util.Scanner;

public class YC {
    public static void main(String[] args) {
        String botName = "YC";
        Scanner scanner = new Scanner(System.in);
        String userCommand;
        Task[] commandList = new Task[100];
        int totalCommands = 0;

        displayWelcomeMessage(botName);

        while (true) {
            userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("bye")) {
                displayByeMessage();
                break;
            }
            if (userCommand.equalsIgnoreCase("list")) {
                System.out.println("\t" + "____________________________________________________________");
                for  (int i = 0; i < totalCommands; i++) {
                    System.out.println("\t" + (i+1) + commandList[i].toString());
                }
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if (userCommand.toLowerCase().startsWith("mark")) {
                int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
                commandList[taskIndex].markAsDone();
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Nice! I've marked this task as done:");
                System.out.println("\t\t" + commandList[taskIndex].toString());
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if (userCommand.toLowerCase().startsWith("unmark")) {
                int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
                commandList[taskIndex].markAsNotDone();
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "OK, I've marked this task as not done yet:");
                System.out.println("\t\t" + commandList[taskIndex].toString());
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if  (userCommand.toLowerCase().startsWith("todo")) {
                // index 5 indicated the starting position of the task description
                String description = userCommand.substring(5);
                commandList[totalCommands] = new Todo(description);
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Got it. I've added this task:");
                System.out.println("\t\t" + commandList[totalCommands].toString());
                totalCommands++;
                System.out.println("\t" + "Now you have "+ totalCommands + " tasks in the list.");
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if  (userCommand.toLowerCase().startsWith("deadline")) {
                // index 9 indicated the starting position of the task description
                String fullDescription = userCommand.substring(9);
                String[] descriptionParts =  fullDescription.split(" /by ");
                String description = descriptionParts[0];
                String by = descriptionParts[1];
                commandList[totalCommands] = new Deadline(description, by);
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Got it. I've added this task:");
                System.out.println("\t\t" + commandList[totalCommands].toString());
                totalCommands++;
                System.out.println("\t" + "Now you have "+ totalCommands + " tasks in the list.");
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

            else if  (userCommand.toLowerCase().startsWith("event")) {
                // index 6 indicated the starting position of the task description
                String fullDescription = userCommand.substring(6);
                String[] descriptionPart1 =  fullDescription.split(" /from ");
                String description = descriptionPart1[0];
                String[] descriptionPart2 = descriptionPart1[1].split(" /to ");
                String from = descriptionPart2[0];
                String to = descriptionPart2[1];
                commandList[totalCommands] = new Event(description, from, to);
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Got it. I've added this task:");
                System.out.println("\t\t" + commandList[totalCommands].toString());
                totalCommands++;
                System.out.println("\t" + "Now you have "+ totalCommands + " tasks in the list.");
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


    private static void displayWelcomeMessage(String botName) {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Hello! I'm " + botName);
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayByeMessage() {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }
}
