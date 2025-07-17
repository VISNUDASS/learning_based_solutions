import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[100];
    static int count = 0;

    public static void addEmployee(int id, String name, String position, double salary) {
        if (count < employees.length) {
            employees[count++] = new Employee(id, name, position, salary);
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee\n2. Search Employee\n3. Display All Employees\n4. Delete Employee\n5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(id, name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter ID to Search: ");
                    int searchId = sc.nextInt();
                    searchEmployee(searchId);
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
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
