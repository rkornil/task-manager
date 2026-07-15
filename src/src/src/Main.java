import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean isRunning = true;

        System.out.println("Вітаю у простому менеджері завдань!");

        while (isRunning) {
            printMenu();
            System.out.print("Обери дію: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введи число!");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewTask(scanner, manager);
                    break;
                case 2:
                    manager.showAllTasks();
                    break;
                case 3:
                    markTaskDone(scanner, manager);
                    break;
                case 4:
                    deleteTask(scanner, manager);
                    break;
                case 5:
                    showStatistics(manager);
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Такого пункту меню немає, спробуй ще раз.");
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("===== МЕНЮ =====");
        System.out.println("1 - Додати завдання");
        System.out.println("2 - Показати всі завдання");
        System.out.println("3 - Позначити завдання як виконане");
        System.out.println("4 - Видалити завдання");
        System.out.println("5 - Статистика");
        System.out.println("0 - Вийти");
    }

    public static void addNewTask(Scanner scanner, TaskManager manager) {
        System.out.print("Назва завдання: ");
        String title = scanner.nextLine();

        System.out.print("Опис завдання: ");
        String description = scanner.nextLine();

        System.out.print("Пріоритет (низький/середній/високий): ");
        String priority = scanner.nextLine();

        Task newTask = new Task(title, description, priority);
        manager.addTask(newTask);

        System.out.println("Завдання додано!");
    }

    public static void markTaskDone(Scanner scanner, TaskManager manager) {
        System.out.print("Введи номер завдання, яке виконано: ");
        String input = scanner.nextLine();

        try {
            int index = Integer.parseInt(input) - 1;
            manager.markTaskAsDone(index);
        } catch (NumberFormatException e) {
            System.out.println("Це не число! Спробуй ще раз.");
        }
    }

    public static void deleteTask(Scanner scanner, TaskManager manager) {
        System.out.print("Введи номер завдання для видалення: ");
        String input = scanner.nextLine();

        try {
            int index = Integer.parseInt(input) - 1;
            manager.removeTask(index);
        } catch (NumberFormatException e) {
            System.out.println("Це не число! Спробуй ще раз.");
        }
    }

    public static void showStatistics(TaskManager manager) {
        int total = manager.getTotalTasks();
        int done = manager.countDoneTasks();

        System.out.println("Всього завдань: " + total);
        System.out.println("Виконано: " + done);

        if (total > 0) {
            int notDone = total - done;
            System.out.println("Не виконано: " + notDone);
        }
    }
}
