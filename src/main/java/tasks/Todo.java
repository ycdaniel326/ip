package tasks;

/**
 * Represents a To-do task with description and completion status.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String toStorage() {
        return "T | " + (isDone ? 1 : 0) + " | " + description;
    }
}