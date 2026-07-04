import java.util.Scanner;

/* This program simulates a basic library
The program allows users to see books,add books, borrow books, and return books
The system manages the inventory and user interactions */

public class Library {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] titles = new String[100]; // Array to store book titles
        String[] authors = new String[100]; // Array to store book authors
        int[] quantities = new int[100]; // Array to store book quantities
        // the [100] is the maximum number of books that can be stored in the library

        titles[0] = "Harry Potter";
        authors[0] = "J.K. Rowling";
        quantities[0] = 5;

        titles[1] = "The Hobbit";
        authors[1] = "J.R.R. Tolkien";
        quantities[1] = 3;

        titles[2] = "The Alchemist";
        authors[2] = "Paulo Coelho";
        quantities[2] = 4;
    
        int totalBooks = 3; // Variable to keep track of the total number of books in the library
        boolean running = true; // Variable to control the loop  
    
        while (running) {

            System.out.println("\n===== LIBRARY MENU =====\n");
            System.out.println("Would you like to:");
            System.out.println("1. See Books");
            System.out.println("2. Add books");
            System.out.println("3. Borrow books");
            System.out.println("4. Return books");
            System.out.println("5. Exit");
            System.out.print("\nChoose an option: ");
    
            try {
                int option = input.nextInt();
                input.nextLine(); // Consume the newline character(↵)

                if (option == 1) {
                    System.out.println("\n===== LIBRARY INVENTORY =====\n");

                    for (int i = 0; i < totalBooks; i++) {
                        System.out.println((i + 1) + ". " + titles[i] + " - " + authors[i] + " (" + quantities[i] + " available)");      
                    }
                }
                else if (option == 2) {
                    System.out.print("\nEnter the title of the book: ");
                    String title = input.nextLine();
                
                    System.out.print("\nEnter the author of the book: ");
                    String author = input.nextLine();

                    System.out.print("\nEnter the quantity of the book: ");
                    int quantity = input.nextInt();
                    input.nextLine();

                    boolean found = false; // Variable to check if the book already exists in the library

                    for (int i = 0; i < totalBooks; i++) {

                        if (titles[i].equalsIgnoreCase(title)) {
                            quantities[i] += quantity; // If the book already exists, increase the quantity
                            found = true;

                            System.out.println("\nBook already exists.");
                            System.out.println("Quantity updated.");
                
                        }
                    }
                    if (!found) {
                        titles[totalBooks] = title; // Add the new book title to the array
                        authors[totalBooks] = author; // Add the new book author to the array
                        quantities[totalBooks] = quantity; // Add the new book quantity to the array

                        totalBooks++; // Increase the total number of different books in the library

                        System.out.println("\nBook added successfully.");
                    }    
                }
                else if (option == 3) {
                    System.out.print("\nEnter the title of the book you want to borrow: ");
                    String title = input.nextLine();

                    System.out.print("\nEnter the quantity of the book you want to borrow: ");
                    int quantity = input.nextInt();
                    input.nextLine();

                    boolean found = false; // Variable to check if the book exists in the library

                    for (int i = 0; i < totalBooks; i++) {
                        
                        if (titles[i].equalsIgnoreCase(title)) {

                            found = true;

                            if (quantities[i] >= quantity) {
                                quantities[i] -= quantity; // Decrease the quantity of the book in the library
                                if (quantity == 1) {
                                    System.out.println("\nBook borrowed successfully.");
                                }
                                else {
                                    System.out.println("\n" + quantity + " books borrowed successfully.");
                                }
                            }
                            else {
                                System.out.println("\nNot enough copies available.");
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("\nBook not found in the library.");
                    }
                }
                else if (option == 4) {
                    System.out.print("\nEnter the title of the book you want to return: ");
                    String title = input.nextLine();

                    System.out.print("\nEnter the quantity of the book you want to return: ");
                    int quantity = input.nextInt();
                    input.nextLine();

                    boolean found = false; // Variable to check if the book exists in the library

                    for (int i = 0; i < totalBooks; i++) {

                        if (titles[i].equalsIgnoreCase(title)) {

                            quantities[i] += quantity; // Increase the quantity of the book in the library
                            found = true;

                            System.out.println("Book returned successfully.");
                    
                        }
                    }
                    if (!found) {
                        System.out.println("This book does not belong to the library.");
                    }
                }
                else if (option == 5) {
                    
                    running = false; // Exit the loop and terminate the program
                    System.out.println("Exiting the program. Goodbye!");
                }
                else {
                    System.out.println("\nInvalid option. Please try again.");
                }
            }
            catch (Exception e) {

                System.out.println("\nInvalid input. Please enter a valid number.");
                input.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
        input.close(); // Close the scanner   
    }    
}
