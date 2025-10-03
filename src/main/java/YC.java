import tasks.TaskList;

/**
 * YC is the class where we run the task manager based on user commands.
 */
public class YC {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     * Constructs a YC instance with the path of a file where the task list is stored.
     * Loads tasks from the stored list, or starts with an empty TaskList.
     *
     * @param filePath path to the stored task list file.
     */
    public YC(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Starts the chatbot and continuously reads user commands until the user exits by typing "bye".
     */
    public void run() {
        ui.displayWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                if (fullCommand.equalsIgnoreCase("bye")) {
                    isExit = true;
                    ui.displayByeMessage();
                }
                else {
                    Parser.parse(fullCommand, tasks, storage);
                }
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Entry point of the program that starts running the chatbot.
     */
    public static void main(String[] args) {
        new YC("data/tasks.txt").run();
    }
}



