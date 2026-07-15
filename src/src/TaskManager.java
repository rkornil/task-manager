import java.util.ArrayList;

// Клас TaskManager зберігає всі завдання і вміє з ними працювати
public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Завдання видалено.");
        } else {
            System.out.println("Такого завдання не існує!");
        }
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
            System.out.println("Завдання позначено як виконане.");
        } else {
            System.out.println("Такого завдання не існує!");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список завдань поки що порожній.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public int countDoneTasks() {
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isDone()) {
                count = count + 1;
            }
        }
        return count;
    }

    public int getTotalTasks() {
        return tasks.size();
    }
}
