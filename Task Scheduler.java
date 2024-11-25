import java.util.PriorityQueue;
import java.util.Scanner;


class Task implements Comparable<Task> {
    String name;
    int priority;
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Priority: " + priority;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        PriorityQueue<Task> taskHeap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Task Scheduler!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Process (Remove) Highest Priority Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task priority (lower number = higher priority): ");
                    int priority = scanner.nextInt();
                    taskHeap.add(new Task(name, priority));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.println("\nCurrent Tasks (sorted by priority):");
                    if (taskHeap.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (Task task : taskHeap) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 3:
                    if (taskHeap.isEmpty()) {
                        System.out.println("No tasks to process.");
                    } else {
                        Task nextTask = taskHeap.poll();
                        System.out.println("Processing Task: " + nextTask);
                    }
                    break;

                case 4:
                    System.out.println("Exiting Task Scheduler. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
