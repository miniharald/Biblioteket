package com.company;

import javax.xml.xpath.XPath;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Library{
    Scanner scan = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books;

    public Library(){
    final Path path = Paths.get("books.txt");
    books = new ArrayList<Book>();
    }

    public void identification(){
        System.out.println("Who would you like to login as?");
        System.out.println("1: Admin");
        System.out.println("2: User");
        byte choice = scan.nextByte();

        if (choice == 1){
            adminMenu();
        }
        if (choice == 2){
            userLoginMenu();
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
    private void userLoginMenu() {
        System.out.println("1: Login\n2: Register");
        String choice = scan.nextLine();
        if (choice.equals("1")){
            loginMenu();
        }
        if(choice.equals("2")){
            register();
        }
    }
    public void loginMenu(){
        System.out.println("What is your login id? ");
        String loginId = scan.nextLine();
        for (User user : users){
            String id = user.getId();

            if (id.equals(loginId)){
                System.out.println("Login successful!");
                userMenu();
                break;
            }
        }
        System.out.println("Login failed.");
    }

    private void userMenu() {
    }

    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Your name:");
        String name = scan.nextLine();
        System.out.println("Your adress:");
        String adress = scan.nextLine();
        System.out.println("Your mail: ");
        String mail = scan.nextLine();
        System.out.println("Telephone number:");
        String tel = scan.nextLine();
        users.add(new User(name, adress, mail, tel));
        int i = users.size() - 1;
        User user = users.get(i);
        String uniqueId = user.getId();
        System.out.printf("Registration completed!\nYour unique id is: %s\n", uniqueId);
        loginMenu();
    }

    public void addBook(){
        Book bok = new Book();

        System.out.println("What is the book's isbn number?: ");
        String isbn = scan.nextLine();
        bok.setIsbn(isbn);

        System.out.println("What is the name of the book?: ");
        String title = scan.nextLine();
        bok.setTitle(title);

        System.out.println("What is the author's name of the book?: ");
        String author = scan.nextLine();
        bok.setAuthor(author);

        System.out.println("What year was the book released?: ");
        String year = scan.nextLine();
        bok.setYear(year);

        System.out.println("What is the genre of the book?: ");
        String genre = scan.nextLine();
        bok.setGenre(genre);
        System.out.println(bok);

        books.add(new Book(title, author, genre, year, isbn));
    }


}
