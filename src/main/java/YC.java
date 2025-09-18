import java.util.Scanner;

import java.util.ArrayList;
import exceptions.EmptyEntryException;
import exceptions.InvalidCommandException;
import exceptions.InvalidFormatException;
import exceptions.InvalidIndexException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;

public class YC {

    static final String BOT_NAME = "YC";
    static ArrayList<Task> commandList = new ArrayList<>();

    public static void main(String[] args) throws InvalidCommandException {
        Scanner scanner = new Scanner(System.in);
        String userCommand;


        displayWelcomeMessage();

        while (true) {
            userCommand = scanner.nextLine().trim();
            try {
                if (userCommand.equalsIgnoreCase("bye")) {
                    displayByeMessage();
                    break;
                }
                if (userCommand.equalsIgnoreCase("list")) {
                    displayList();
                } else if (userCommand.toLowerCase().startsWith("mark")) {
                    MarkTask(userCommand);
                } else if (userCommand.toLowerCase().startsWith("unmark")) {
                    UnmarkTask(userCommand);
                } else if (userCommand.toLowerCase().startsWith("todo")) {
                    ProcessTodo(userCommand);
                } else if (userCommand.toLowerCase().startsWith("deadline")) {
                    ProcessDeadline(userCommand);
                } else if (userCommand.toLowerCase().startsWith("event")) {
                    ProcessEvent(userCommand);
                } else {
                    throw new InvalidCommandException("Please enter a valid command!");
                }

            } catch (EmptyEntryException | InvalidIndexException |
                     InvalidFormatException | InvalidCommandException e ) {
                System.out.println("\t" + e.getMessage());
            }

        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Hello! I'm " + YC.BOT_NAME);
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayByeMessage() {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Bye. Hope to see you again soon!");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayList() {
        System.out.println("\t" + "____________________________________________________________");
        for  (int i = 0; i < commandList.size(); i++) {
            System.out.println("\t" + (i+1) + commandList.get(i).toString());
        }
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void MarkTask(String userCommand)
            throws InvalidIndexException {
        int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
        if (taskIndex < 0 || taskIndex >= commandList.size()) {
            throw new InvalidIndexException("This is not a valid task index");
        }
        commandList.get(taskIndex).markAsDone();
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Nice! I've marked this task as done:");
        System.out.println("\t\t" + commandList.get(taskIndex).toString());
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void UnmarkTask(String userCommand)
            throws InvalidIndexException {
        int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
        if (taskIndex < 0 || taskIndex >= commandList.size()) {
            throw new InvalidIndexException("This is not a valid task index");
        }
        commandList.get(taskIndex).markAsNotDone();
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "OK, I've marked this task as not done yet:");
        System.out.println("\t\t" + commandList.get(taskIndex).toString());
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayAddedCommand() {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Got it. I've added this task:");
        System.out.println("\t\t" + commandList.get(commandList.size()-1).toString());
        System.out.println("\t" + "Now you have "+ commandList.size() + " tasks in the list.");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void ProcessTodo(String userCommand)
            throws EmptyEntryException {
        int TODO_CONTENT_INDEX = 5;
        if (userCommand.length() <= TODO_CONTENT_INDEX) {
            throw new EmptyEntryException();
        }
        String description = userCommand.substring(TODO_CONTENT_INDEX);
        commandList.add(new Todo(description));
        displayAddedCommand();
    }

    private static void ProcessDeadline(String userCommand)
            throws EmptyEntryException, InvalidFormatException {

        int DEADLINE_CONTENT_INDEX = 9;
        if (userCommand.length() <= DEADLINE_CONTENT_INDEX) {
            throw new EmptyEntryException();
        }
        String fullDescription = userCommand.substring(DEADLINE_CONTENT_INDEX);
        if (!fullDescription.contains("/by")) {
            throw new InvalidFormatException("You are missing a '/by' in the command.");
        }
        String[] descriptionParts =  fullDescription.split(" /by ");
        if (descriptionParts.length != 2 || descriptionParts[0].isEmpty() ||  descriptionParts[1].isEmpty()) {
            throw new InvalidFormatException("You should enter with the format: 'description' /by 'deadline'");
        }
        String description = descriptionParts[0];
        String by = descriptionParts[1];
        commandList.add(new Deadline(description, by));
        displayAddedCommand();
    }

    private static void ProcessEvent(String userCommand)
            throws EmptyEntryException, InvalidFormatException {
        int EVENT_CONTENT_INDEX = 6;
        if (userCommand.length() <= EVENT_CONTENT_INDEX) {
            throw new EmptyEntryException();
        }
        String fullDescription = userCommand.substring(EVENT_CONTENT_INDEX);
        if (!fullDescription.contains("/from") || !fullDescription.contains("/to")) {
            throw new InvalidFormatException("You are missing a '/from' or '/to' in the command.");
        }
        String[] descriptionPart1 =  fullDescription.split(" /from ");
        if (descriptionPart1.length != 2 || descriptionPart1[0].isEmpty() ||  descriptionPart1[1].isEmpty()) {
            throw new InvalidFormatException("You should enter with the format: 'description' /from 'start' /to 'end'");
        }
        String description = descriptionPart1[0];
        String[] descriptionPart2 = descriptionPart1[1].split(" /to ");
        if (descriptionPart2.length != 2 || descriptionPart2[0].isEmpty() ||  descriptionPart2[1].isEmpty()) {
            throw new InvalidFormatException("You should enter with the format: 'description' /from 'start' /to 'end'");
        }
        String from = descriptionPart2[0];
        String to = descriptionPart2[1];
        commandList.add(new Event(description, from, to));
        displayAddedCommand();
    }
}
