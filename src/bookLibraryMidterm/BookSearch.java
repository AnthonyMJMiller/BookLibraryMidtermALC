package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch {
	static ArrayList<Book> bookList = BookInventory.bookArray();
	static Scanner scnr = new Scanner(System.in);



	public BookSearch() {

	}
	
	/*  Method gather string from user
    Matches string with string content in BookInventory.getBookAuthor and
    prints out information for these books
    do while loop for search reusability on user's choice
    Enters into BookInventory.bookCheckout method
    Prints message if no matches appear
*/

	public static void searchByAuthor() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
			String userSearch = Validator.getString("Please enter author name: ");
			
				System.out.printf("\n%-4s %-28s %-24s %-5s\n", "ID", "Title", "Author", "Status");
				System.out.println("------------------------------------------------------------------");

				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					// Chained .toLowerCase method to ignore case sensitivity
					if (BookInventory.bookArray().get(i).getBookAuthor().toLowerCase().contains(userSearch.toLowerCase())) {
						Book b = bookList.get(i);

						System.out.printf("\n%-5d%-30s%-25s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
								b.getBookStatus());
						
						tryAgain = false;
					}

				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

		} 
			enter = Validator.getString("\nDo you want to find another book? (Y/N) ");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString("Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}

		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(bookList);
	}
	
	/*  Method gather string from user
    Matches string with string content in BookInventory.getBookTitle and
    prints out information for these books
    do while loop for search reusability on user's choice
    Enters into BookInventory.bookCheckout method
    Prints message if no matches appear
*/
	
	public static void searchByTitle() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
				String userSearch = Validator.getString("Please enter a title keyword: ");
				System.out.printf("\n%-4s %-28s %-24s %-5s\n", "ID", "Title", "Author", "Status");
				System.out.println("------------------------------------------------------------------");
				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					if(BookInventory.bookArray().get(i).getBookTitle().toLowerCase().contains(userSearch.toLowerCase())) {
						Book b = bookList.get(i);

						System.out.printf("\n%-5d%-30s%-25s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
								b.getBookStatus());
						
						tryAgain = false;
					} 
				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

			}
			enter = Validator.getString("\nDo you want to find another book? (Y/N) ");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString("Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}
		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(bookList);
	}
}
