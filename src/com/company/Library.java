package com.company;

import javax.xml.xpath.XPath;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Library {
    Scanner scan = new Scanner(System.in);
    public Library(){
    final Path path = Paths.get("books.txt");
    }

    public void identification(){
        System.out.println("Who are you?");
        System.out.println("1: Admin");
        System.out.println("2: User");
        byte choice = scan.nextByte();

        if (choice == 1){
            adminMenu();
        }
        if (choice == 2){
            userMenu();
        }
    }

    private void adminMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1: Add book to library");
        System.out.println("2: Remove book from library");
        System.out.println("3: Edit book in library");
        byte choice = scan.nextByte();
        if (choice == 1){
            addBook();
        }
    }

    private void userMenu() {
        System.out.println("You are a user");
    }

    public void addBook(){
        Book bok = new Book();
        String isbn;
        String title;
        String author;
        byte qty;
        String year;
        String genre;
        System.out.println("What is the book's isbn number?: ");
        isbn = scan.nextLine();
        bok.setIsbn(isbn);

        System.out.println("What is the name of the book?: ");
        title = scan.nextLine();
        bok.setTitle(title);

        System.out.println("What is the author's name of the book?: ");
        author = scan.nextLine();
        bok.setAuthor(author);

        System.out.println("How many books would you like to add?: ");
        qty = scan.nextByte();
        bok.setQty(qty);

        System.out.println("What year was the book released?: ");
        year = scan.nextLine();
        bok.setYear(year);

        System.out.println("What is the genre of the book?: ");
        genre = scan.nextLine();
        bok.setGenre(genre);
        System.out.println(bok);
    }


}
