// Клас Task описує одне завдання в нашому списку справ
public class Task {
    private String title;
    private String description;
    private String priority; // низький, середній або високий
    private boolean isDone;

    public Task(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDone = false; // нове завдання завжди не виконане
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    // Метод toString допомагає красиво вивести завдання на екран
    @Override
    public String toString() {
        String status;
        if (isDone) {
            status = "[Виконано]";
        } else {
            status = "[Не виконано]";
        }
        return status + " " + title + " (пріоритет: " + priority + ") - " + description;
    }
}
