package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;
public class TerminalApp {
	static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {

		// System.out.println(BookInventory.bookArray());
		//Inherit info from book class, like variables?
		greetUser("Welcome to the DPL Library Terminal. How may i help you today?",scnr);

	}
	public static void greetUser(String prompt, Scanner scnr) {
		System.out.println(prompt);
		System.out.println("1. Display all books");
		System.out.println("2. Search by Keyword");
		System.out.println("3. Search by Author");
		System.out.println("4. Return book");
		System.out.println("5. Quit");

		int accessIDCheck = scnr.nextInt();
		boolean isValid = false; 
		int accessID = 0;
		
		ArrayList<Book> displayBooks = BookInventory.bookArray();

		do {
			if (accessIDCheck <= 4) {
				accessID = accessIDCheck;
				isValid = true;
			}
			else if(accessIDCheck <= 0)  {
				System.out.println("Sorry this is not a valid terminal key, please try again or contact help desk");
			}
			else if(accessIDCheck > 4 ) {
				System.out.println("Sorry this is not a valid terminal key, please try again or contact help desk");
			}
		}while(!isValid);
		
		switch(accessID) {
		
		case 1:
			BookInventory.listBooks(displayBooks);
			String choice = Validator.getString(scnr, "Would you like to checkout one of these items? y/n");

			break;
		case 2:
			// BookSearch.searchByTitle();
			break;
		case 3:
			BookSearch.searchByAuthor("test");
			break;
		case 4:
			// BookInventory.bookReturn();
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
