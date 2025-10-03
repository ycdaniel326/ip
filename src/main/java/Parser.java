import exceptions.EmptyEntryException;
import exceptions.InvalidCommandException;
import exceptions.InvalidFormatException;
import exceptions.InvalidIndexException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;
import tasks.TaskList;

public class Parser {

    public static void parse(String userCommand, TaskList tasks, Storage storage) {
        try {
            if (userCommand.equalsIgnoreCase("list")) {
                displayList(tasks);
            } else if (userCommand.toLowerCase().startsWith("mark")) {
                markTask(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("unmark")) {
                unmarkTask(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("delete")) {
                deleteTask(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("find")) {
                findTask(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("todo")) {
                processTodo(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("deadline")) {
                processDeadline(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else if (userCommand.toLowerCase().startsWith("event")) {
                processEvent(userCommand, tasks);
                storage.saveTasks(tasks.getList());
            } else {
                throw new InvalidCommandException("Please enter a valid command!");
            }

        } catch (EmptyEntryException | InvalidIndexException |
                 InvalidFormatException | InvalidCommandException e) {
            System.out.println("\t" + e.getMessage());
        }
    }

    private static void displayList(TaskList tasks) {
        System.out.println("\t" + "____________________________________________________________");
        for  (int i = 0; i < tasks.getList().size(); i++) {
            System.out.println("\t" + (i+1) + tasks.get(i).toString());
        }
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void markTask(String userCommand, TaskList tasks)
            throws InvalidIndexException {
        int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new InvalidIndexException("This is not a valid task index");
        }
        tasks.get(taskIndex).markAsDone();
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Nice! I've marked this task as done:");
        System.out.println("\t\t" + tasks.get(taskIndex).toString());
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void unmarkTask(String userCommand, TaskList tasks)
            throws InvalidIndexException {
        int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new InvalidIndexException("This is not a valid task index");
        }
        tasks.get(taskIndex).markAsNotDone();
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "OK, I've marked this task as not done yet:");
        System.out.println("\t\t" + tasks.get(taskIndex).toString());
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void deleteTask(String userCommand, TaskList tasks)
            throws InvalidIndexException {
        int taskIndex = Integer.parseInt(userCommand.split(" ")[1]) - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new InvalidIndexException("This is not a valid task index");
        }
        Task deletedTask = tasks.get(taskIndex);
        tasks.remove(taskIndex);
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Noted. I've removed this task:");
        System.out.println("\t\t" + deletedTask.toString());
        System.out.println("\t" + "Now you have " + tasks.size()+ " tasks in the list.");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void findTask(String userCommand, TaskList tasks)
            throws EmptyEntryException {
        int FIND_CONTENT_INDEX = 5;
        if (userCommand.length() <= FIND_CONTENT_INDEX) {
            throw new EmptyEntryException();
        }
        String taskWord = userCommand.substring(FIND_CONTENT_INDEX).toLowerCase();

        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Here are the matching tasks in your list:");
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            String taskDescription = tasks.get(i).toString().toLowerCase();
            if (taskDescription.contains(taskWord)) {
                count++;
                System.out.println("\t" + count + "." + tasks.get(i));
            }
        }
        if (count == 0) {
            System.out.println("\t" + "No matching tasks found.");
        }
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void displayAddedCommand(TaskList tasks) {
        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Got it. I've added this task:");
        System.out.println("\t\t" + tasks.get(tasks.size()-1).toString());
        System.out.println("\t" + "Now you have "+ tasks.size() + " tasks in the list.");
        System.out.println("\t" + "____________________________________________________________" + "\n");
    }

    private static void processTodo(String userCommand, TaskList tasks)
            throws EmptyEntryException {
        int TODO_CONTENT_INDEX = 5;
        if (userCommand.length() <= TODO_CONTENT_INDEX) {
            throw new EmptyEntryException();
        }
        String description = userCommand.substring(TODO_CONTENT_INDEX);
        tasks.add(new Todo(description));
        displayAddedCommand(tasks);
    }

    private static void processDeadline(String userCommand, TaskList tasks)
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
        tasks.add(new Deadline(description, by));
        displayAddedCommand(tasks);
    }

    private static void processEvent(String userCommand, TaskList tasks)
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
        tasks.add(new Event(description, from, to));
        displayAddedCommand(tasks);
    }
}
