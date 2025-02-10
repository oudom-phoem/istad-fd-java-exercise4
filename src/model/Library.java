package model;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            System.out.println("[!] Not a book, can't be add to the library.");
        }
    }

    public void registerMember(Member member) {
        if (member != null) {
            members.add(member);
        } else {
            System.out.println("[!] Not a valid user, can't be add to the library.");
        }
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("Displaying All Books:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }

    public void displayMembers() {
        System.out.println("Displaying All Members:");
        for (Member member : members) {
            System.out.println(member.getDetails());
        }
    }
}
