import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(filePath);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs();
                System.out.println("a new folder has been created.");
            }
            if (file.createNewFile()) {
                System.out.println("tasks file has been created.");
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");
                String part1 = parts[0];
                int part2 = Integer.parseInt(parts[1]);
                String description = parts[2];

                Task task = null;
                if (part1.equals("T")) {
                    task = new Todo(description);
                } else if (part1.equals("D")) {
                    task = new Deadline(description, parts[3]);
                } else if (part1.equals("E")) {
                    task = new Event(description, parts[3], parts[4]);
                }
                if (part2 == 1) {
                    task.markAsDone();
                }
                tasks.add(task);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error occurs when loading: " + e.getMessage());
        }
        return tasks;
    }

    public void saveTasks(ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(this.filePath);
            for (Task t : tasks) {
                fw.write(t.toStorage() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurs when saving: " + e.getMessage());
        }
    }
}
