package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalApp {
	static Scanner scnr = new Scanner(System.in);
	static boolean cont = true;
	static ArrayList<Book> bookList = BookInventory.bookArray();

	public static void main(String[] args) {

		while (cont) {
			greetUser();
			userSelect();
			String userChoice = Validator.getString(scnr, "Would you like to return to the main menu? y/n ");
			if (userChoice.equalsIgnoreCase("n")) {
				cont = false;
			}
		}
		BookInventory.writeBooksTxt(bookList);
		System.out.println("Goodbye! Thank you for visiting your virtual library.");

	}

	public static void greetUser() {

		System.out.println("Welcome to the DPL Library Terminal. How may i help you today?");
		System.out.println("1. Display all books");
		System.out.println("2. Search by Keyword");
		System.out.println("3. Search by Author");
		System.out.println("4. Return book");
		System.out.println("5. Quit");
	}

	public static void userSelect() {

		int accessID = Validator.getInt(scnr, "Please select a menu item: ", 1, 5);

		switch (accessID) {

		case 1:
			BookInventory.listBooks(bookList);
			String choice = Validator.getString(scnr, "\nWould you like to checkout one of these items? y/n ");

			if (choice.equalsIgnoreCase("y")) {
				BookInventory.bookCheckout(bookList);
			} else {
				System.out.println("false?");
			}

		case 2:
			BookSearch.searchByTitle();
			break;
		case 3:
			BookSearch.searchByAuthor();
			break;
		case 4:
			BookInventory.bookReturn();
			break;
		case 5:
			BookInventory.writeBooksTxt(bookList);
			System.out.println("Goodbye! Thank you for visiting your virtual library.");
			System.exit(0);
			break;
		}
	}

}
