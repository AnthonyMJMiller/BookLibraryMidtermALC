package bookLibraryMidterm;

import java.util.Scanner;

public class TerminalApp {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		boolean isValid = false;

		do {
			greetUser();
			userSelect();
			isValid = true;
		} while (!isValid);

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
			BookInventory.listBooks();

		case 2:
			BookSearch.searchByTitle();
			break;
		case 3:
			BookSearch.searchByAuthor();
			break;
		case 4:
			BookInventory.bookReturn();
			break;
		}
	}

	public static void bookSearch() {
		BookSearch bs = new BookSearch();

		System.out.println("Would you like to search by author or by title?");
		System.out.println("Key: 1-Author. 2-Title.");
		int userInput = scnr.nextInt();
		scnr.nextLine();

//		switch(userInput) {
//		case 1:
//			bs.searchByAuthor("Please enter the author name of the book you are looking for",scnr);
//			break;searchByTitle
//		case 2:
//			bs.searchByTitle();
//			break;
//		}
	}

}
