# Exercise: Create a Library Management System 

You are tasked with creating a simple Library Management System using Object-Oriented Programming (OOP) principles in Java. The system should handle books and members of a library.

## 1. Define Classes
- ### Book
  - #### Properties
    - id (unique identifier, int)
    - title (String)
    - author (String)
    - isAvailable (boolean, default: true)

  - #### Methods
    - Constructor to initialize all fields.
    - getDetails() to display the book's details.
    - borrowBook() to mark the book as borrowed.
    - returnBook() to mark the book as available.

- ### Member
    - #### Properties
        - id (unique identifier, int)
        - name (String)
        - borrowedBooks (List of books)

    - #### Methods
        - Constructor to initialize all fields.
        - borrowBook(Book book) to allow the member to borrow a book if it is available.
        - returnBook(Book book) to allow the member to return a book.
        - getDetails() to display the member's details, including borrowed books.

- ### Library
    - #### Properties
        - books (List of all books in the library)
        - members (List of all members in the library)

    - #### Methods
        - addBook(Book book) to add a new book to the library.
        - registerMember(Member member) to register a new member.
        - findBookById(int id) to find a book by its ID.
        - findMemberById(int id) to find a member by their ID.
        - displayBooks() to display all books in the library.
        - displayMembers() to display all members of the library.

## 2. Task Implementation
1. Create the Book, Member, and Library classes in Java.
2. Use encapsulation by keeping the class properties private and providing getters and setters as necessary.
3. Demonstrate the following in a main method:
- Add books and members to the library.
- Borrow and return books using members.
- Display all books and members along with their statuses.

========================== <br />
Sample Output <br />
==========================

Welcome to the Library Management System! <br />
Adding Books... <br />
Adding Members... <br />
Displaying All Books: <br />
1 - The Great Gatsby by F. Scott Fitzgerald (Available) <br />
2 - To Kill a Mockingbird by Harper Lee (Available) <br />
Displaying All Members: <br />
1 - Alice (No books borrowed) <br />
2 - Bob (No books borrowed) <br />
Bob borrows "The Great Gatsby"... <br />
Displaying All Books: <br />
1 - The Great Gatsby by F. Scott Fitzgerald (Not Available) <br />
2 - To Kill a Mockingbird by Harper Lee (Available) <br />
Displaying All Members: <br />
1 - Alice (No books borrowed) <br />
2 - Bob (Books borrowed: The Great Gatsby) <br />
Bob returns "The Great Gatsby"... <br />
Displaying All Books: <br />
1 - The Great Gatsby by F. Scott Fitzgerald (Available) <br />
2 - To Kill a Mockingbird by Harper Lee (Available) <br />
Displaying All Members: <br />
1 - Alice (No books borrowed) <br />
2 - Bob (No books borrowed) <br />

