import tasks.TaskList;

public class YC {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;

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
    public static void main(String[] args) {
        new YC("data/tasks.txt").run();
    }

}



