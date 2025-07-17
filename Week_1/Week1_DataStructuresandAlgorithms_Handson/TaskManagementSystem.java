import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    void display() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

public class TaskManagementSystem {
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public void traverseTasks() {
        Task temp = head;
        if (temp == null) {
            System.out.println("No tasks available.");
            return;
        }
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && current.taskId != id) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
        } else {
            previous.next = current.next;
            System.out.println("Task deleted.");
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Task\n2. Search Task\n3. Display All Tasks\n4. Delete Task\n5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    tms.addTask(id, name, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to Search: ");
                    int searchId = sc.nextInt();
                    tms.searchTask(searchId);
                    break;
                case 3:
                    tms.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to Delete: ");
                    int deleteId = sc.nextInt();
                    tms.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
