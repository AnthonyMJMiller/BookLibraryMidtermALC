package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TerminalApp extends TerminalAppGUI {
	/*
	 * Made variables universal in class to cut redundancy using same variables in
	 * each method
	 */
	static Scanner scnr = new Scanner(System.in);
	static boolean cont = true;
	static ArrayList<Book> bookList = BookInventory.bookArray();

	public static void main(String[] args) {
		// We utilized GUI for user interaction in Library Terminal program
		new TerminalAppGUI().setVisible(true);
		
		System.out.println("Welcome to Art Garfunkel's Library Terminal.\n");
		/*
		 *  While loop w/boolean to loop back to main menu until exit option
		 *  selected
		 */
		while (cont) {
			greetUser();
			userSelect();

		}
		BookInventory.writeBooksTxt(bookList);
		System.out.println("Goodbye! Thank you for visiting your virtual library.");

	}

	public static void greetUser() {
		System.out.println("-------------------------");
		System.out.println("How may I help you today?");
		System.out.println("-------------------------");
		System.out.println("1. Display all books");
		System.out.println("2. Search by Keyword");
		System.out.println("3. Search by Author");
		System.out.println("4. Return book");
		System.out.println("5. Quit");
	}

	public static void userSelect() {
		/*
		 *  We take in a number from user and use that number to navigate via case
		 *  switch
		 */
		int accessID = Validator.getInt("\nPlease select a menu item: ", 1, 5);
		
		switch (accessID) {

		case 1:
			BookInventory.listBooks(bookList);
			String choice = Validator.getYN("Would you like to checkout one of these items? y/n ");

			if (choice.equalsIgnoreCase("y")) {
				BookInventory.bookCheckout(bookList);
			}
			break;
		case 2:
			BookSearch.searchByTitle();
			break;
		case 3:
			BookSearch.searchByAuthor();
			break;
		case 4:
			BookInventory.bookReturn(bookList);
			break;
		case 5:
			// Writes to books.txt file before exiting to save last interaction(s)
			BookInventory.writeBooksTxt(bookList);
			System.out.println("Goodbye! Thank you for visiting.");
			System.exit(0);
			break;
		}
	}

}
