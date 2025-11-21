package com.MiniProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id,String title,String author){
    this.id =id;
    this.title=title;
    this.author=author;
    this.isIssued=false; //by default the book is available
    }
    //using getter and setter to access private fields
    public void setId(String id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setIssued(boolean isIssued){
        this.isIssued=isIssued;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isIssued(){
        return isIssued;
    }

   // to print the book details
    @Override
    public String toString() {
        return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", isIssued=" + isIssued + '}';
    }
}

class Member {
    private String memberId;
    private String memberName;
    private List<String> borrowedBookIds; //keeps only the id's of the book borrowed and not whole book

    public Member(String memberId ,String memberName){
        this.memberId=memberId;
        this.memberName=memberName;
        this.borrowedBookIds= new ArrayList<String>();
    }

    public void setMemberId(String memberId){
        this.memberId=memberId;
    }
    public void setMemberName(String memberName){
        this.memberName=memberName;
    }
    public void setBorrowedBookIds(List<String> borrowedBookIds){
        this.borrowedBookIds= borrowedBookIds;
    }

    public String getMemberId(){
        return memberId;
    }
    public String getMemberName(){
        return memberName;
    }
    public List<String> getBorrowedBookIds(){
        return borrowedBookIds;
    }


    public void borrowBook(String bookId){
        this.borrowedBookIds.add(bookId);
    }
    public void returnBook(String bookId){
        borrowedBookIds.remove(bookId);
    }

    @Override
    public String toString() {
        return "Member{" + "memberId='" + memberId + '\'' + ", memberName='" + memberName + '\'' + ", borrowedBookIds=" + borrowedBookIds + '}';
    }

}

class Library{
    private HashMap<String, Book> inventory;
    private HashMap<String, Member> members;
    public Library(){
        inventory = new HashMap<>();
        members = new HashMap<>();
    }

    public void addBook(Book book){
        inventory.put(book.getId(), book);
        logOperation("Added book :" + book.getTitle());
    }

    public void addMember(Member member){
        members.put(member.getMemberId(), member);
        logOperation("Added member : " +member.getMemberName());
    }

    public void issueBook(String bookId , String memberId) throws BookNotAvailableException{
        Book book = inventory.get(bookId);
        if(book==null){
            throw new BookNotAvailableException("Book not found: " + bookId);
        }
        Member member = members.get(memberId);
        if(member==null){
            throw new BookNotAvailableException("Member not found: " + memberId);
        }
        if(book.isIssued()){
            throw new BookNotAvailableException("Book is already issued:" + bookId );
        }

        book.setIssued(true);
        member.borrowBook(bookId);
        logOperation("Issued book" + bookId + " to member" + memberId);

    }

    public void returnBook(String bookId , String memberId, int daysLate) throws InvalidReturnException {
        Book book =inventory.get(bookId);
        if(book==null){
            throw new InvalidReturnException("Book doesn't exist" + bookId);
        }

        Member member = members.get(memberId);
        if(member==null){
            throw new InvalidReturnException("Member doesn't exist " + memberId);
        }

        if(!member.getBorrowedBookIds().contains(bookId)){
            throw new InvalidReturnException("This member didn't borrow book" + bookId);
        }
        book.setIssued(false);
        member.returnBook(bookId);

        int fine=0;
        if(daysLate>0){
            fine=daysLate*2;
            System.out.println("Late by "+ daysLate + "days. Fine: ₹" +fine);
        }
        else{
            System.out.println("Book returned on time !");
        }
        logOperation("Returned book " + bookId + " from member " + memberId + ", Late days: " + daysLate + ", Fine: ₹" + fine);
    }

    public void logOperation(String message) {
        try {
            FileWriter writer = new FileWriter("library_log.txt", true); // append mode
            writer.write(LocalDateTime.now() + " - " + message + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public void showInventory(){
        if(inventory.isEmpty()){
            System.out.println("No books in the library");
            return;
        }

        System.out.println("---- Library Inventory ----");
        for(Book b :inventory.values()){
            System.out.println(b);
        }
    }
}

class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}

class InvalidReturnException extends Exception {
    public InvalidReturnException(String message){
        super(message);
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book (with late fee calculation: ₹2/day ");
            System.out.println("5. Show Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice =sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                System.out.println("Enter Book ID: ");
                String id = sc.nextLine();
                System.out.println("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.println("Enter Book Author: ");
                String author = sc.nextLine();
                Book book = new Book(id, title, author);
                library.addBook(book);
                System.out.println("Book added successfully");
                break;

            case 2:
                System.out.println("Enter Member ID: ");
                String memberId = sc.nextLine();
                System.out.println("Enter Member Name: ");
                String memberName = sc.nextLine();
                Member member = new Member(memberId, memberName);
                library.addMember(member);
                System.out.println("Member added successfully");
                break;

            case 3:
                System.out.println("Enter Book ID to issue: ");
                String bookIdToIssue = sc.nextLine();
                System.out.println("Enter Member ID: ");
                String memberIdIssue = sc.nextLine();
                try {
                    library.issueBook(bookIdToIssue, memberIdIssue);
                    System.out.println("Book issued successfully");
                } catch (BookNotAvailableException e) {
                    System.out.println("Cannot issue book" + e.getMessage());
                }
                break;

            case 4:
                System.out.println("Enter Book ID to return: ");
                String bookIdToReturn = sc.nextLine();
                System.out.println("Enter Member ID: ");
                String memberIdReturn = sc.nextLine();
                System.out.print("Enter days late (0 if on time): ");
                int daysLate = sc.nextInt();
                sc.nextLine();
                try {
                    library.returnBook(bookIdToReturn, memberIdReturn, daysLate);
                    System.out.println("Book returned successfully");
                } catch (InvalidReturnException e) {
                    System.out.println("Return Failed " + e.getMessage());
                }
                break;

            case 5:
                library.showInventory();
                break;

            case 6:
                System.out.println("Exiting...Goodbye!");
                return;

            default:
                System.out.println("Invalid choice. Try again");
           }
        }
    }
}
