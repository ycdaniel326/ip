package tasks;

import java.util.ArrayList;

/**
 * Operates the ArrayList of tasks.
 * Includes operations to add, remove, and get task.
 * Includes operations to get the number of tasks and get the TaskList.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList based on an existing TaskList.
     *
     * @param tasks The existing list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task referred by the index.
     *
     * @param index The specified index of the task.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the size of the TaskList (number of tasks stored).
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Adds a task to the TaskList.
     *
     * @param t The Task object to be added to TaskList.
     */
    public void add(Task t) {
        tasks.add(t);
    }

    /**
     * Removes a task from the TaskList.
     *
     * @param index The index of the task to be removed.
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the TaskList.
     */
    public ArrayList<Task> getList() {
        return tasks;
    }
}
