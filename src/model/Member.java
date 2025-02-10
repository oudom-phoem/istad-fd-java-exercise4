package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(Book book) {
        if (book.borrowBook()) {
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (book.returnBook()) {
            borrowedBooks.remove(book);
        }
    }

    public String getDetails() {
        String status = borrowedBooks.isEmpty() ? "No books borrowed" : "Book borrowed: ";
        String bookList = borrowedBooks.stream().map(Book::getTitle).toList().toString();
        return id + " - " + name + " (" + status + bookList.replace("[", "").replace("]", "") + ")";

    }

    public int getId() {
        return id;
    }
}
