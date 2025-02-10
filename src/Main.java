import model.Book;
import model.Library;
import model.Member;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static  Library library = new Library();

    public static void main(String[] args) {
        System.out.println("Welcome to the Library Management System!");
        System.out.println("Adding Books...");
        System.out.println("Adding Members...");

        // Preloaded Books
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "1984", "George Orwell"));
        library.addBook(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(5, "Moby-Dick", "Herman Melville"));

        // Preloaded Members
        library.registerMember(new Member(1, "Alice"));
        library.registerMember(new Member(2, "Bob"));
        library.registerMember(new Member(3, "Charlie"));
        library.registerMember(new Member(4, "David"));
        library.registerMember(new Member(5, "Emma"));

        while (true) {
            displayMenu();
            int option = getOption();
            scanner.nextLine();
            System.out.println();
            switch(option) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> library.displayBooks();
                case 4 -> library.displayMembers();
                case 5 -> addBook();
                case 6 -> registerMember();
                case 7 -> {
                    if (isExit()) {
                        System.out.println("Thank you for using our system, Goodbye.");
                        scanner.close();
                        return;
                    }
                }
            }
        }

    }

    static void displayMenu() {
        System.out.println("\n===== Options =====");
        System.out.println("1. Borrow");
        System.out.println("2. Return");
        System.out.println("3. Display All Books");
        System.out.println("4. Display All Members");
        System.out.println("5. Add Book");
        System.out.println("6. Register Member");
        System.out.println("7. Exit");
    }

    static int getOption() {
        System.out.print("> Enter your option: ");
        return scanner.nextInt();
    }

    static void borrowBook() {
        System.out.print("[+] Enter member id: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = library.findMemberById(memberId);

        if (member != null) {
            System.out.print("[+] Enter book id: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            Book book = library.findBookById(bookId);

            if (book != null) {
                member.borrowBook(book);
            } else {
                System.out.println("[!] This book does not exit.");
            }
        } else {
            System.out.println("[!] This member does not exit.");
        }
    }

    static void returnBook() {
        System.out.print("[+] Enter member id: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = library.findMemberById(memberId);

        if (member != null) {
            System.out.print("[+] Enter book id: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            Book book = library.findBookById(bookId);
            if (book != null) {
                member.returnBook(book);
            } else {
                System.out.println("[+] This book does not exit.");
            }
        } else {
            System.out.println("[!] This member does not exit.");
        }
    }

    static void addBook() {
        System.out.print("[+] Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.findBookById(id) != null) {
            System.out.println("[!] A book with this ID already exists!");
            return;
        }

        System.out.print("[+] Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("[+] Enter book author: ");
        String author = scanner.nextLine().trim();

        Book newBook = new Book(id, title, author);
        library.addBook(newBook);
        System.out.println("[✔] Book added successfully!");
    }

    static void registerMember() {
        System.out.print("[+] Enter member id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.findMemberById(id) != null) {
            System.out.println("[!] A member with this ID already exists!");
            return;
        }

        System.out.print("[+] Enter member name: ");
        String name = scanner.nextLine().trim();

        Member newMember = new Member(id, name);
        library.registerMember(newMember);
        System.out.println("[✔] Member registered successfully!");
    }

    static boolean isExit() {
        System.out.print("Confirm to exit. (y/n): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }

}
