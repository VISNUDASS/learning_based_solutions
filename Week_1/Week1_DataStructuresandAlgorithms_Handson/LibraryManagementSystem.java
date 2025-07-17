import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagementSystem {
    static Book[] books = new Book[100];
    static int count = 0;

    public static void addBook(int id, String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(id, title, author);
        } else {
            System.out.println("Book list is full.");
        }
    }

    public static void linearSearchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                books[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0, right = count - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                books[mid].display();
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }

    public static void displayAllBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Book\n2. Linear Search by Title\n3. Binary Search by Title\n4. Display All Books\n5. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    addBook(id, title, author);
                    break;
                case 2:
                    System.out.print("Enter Title to Search (Linear): ");
                    String linTitle = sc.nextLine();
                    linearSearchByTitle(linTitle);
                    break;
                case 3:
                    System.out.print("Enter Title to Search (Binary): ");
                    String binTitle = sc.nextLine();
                    binarySearchByTitle(binTitle);
                    break;
                case 4:
                    displayAllBooks();
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
