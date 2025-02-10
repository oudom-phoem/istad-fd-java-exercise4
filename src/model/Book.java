package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been successfully borrowed.");
            return true;
        } else {
            System.out.println(title + " is not available.");
            return false;
        }
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been successfully returned.");
            return true;
        } else {
            System.out.println(title + " is already available.");
            return false;
        }
    }

    public String getDetails() {
        String status = isAvailable ? "Available" : "Not Available";
        return id + " - " + title + " by " + author + " (" + status + ")";
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
