package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch {
	static ArrayList<Book> chosenBook = new ArrayList<>();
	static Scanner scnr = new Scanner(System.in);



	public BookSearch() {

	}

	public static void searchByAuthor() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
			String userSearch = Validator.getString(scnr, "Please enter author name: ");
			
				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					if (BookInventory.bookArray().get(i).getBookAuthor().contains(userSearch)) {
						System.out.println(BookInventory.bookArray().get(i));
						chosenBook.add(BookInventory.bookArray().get(i));
						tryAgain = false;
					}

				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

		} 
			enter = Validator.getString(scnr, "Do you want to find another book? (Y/N)");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString(scnr, "Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}

		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(chosenBook);
	}

	public static void searchByTitle() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
				String userSearch = Validator.getString(scnr, "Please enter title name: ");
				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					if(BookInventory.bookArray().get(i).getBookTitle().contains(userSearch)) {
						System.out.println(BookInventory.bookArray().get(i));
						chosenBook.add(BookInventory.bookArray().get(i));
						tryAgain = false;
					} 
				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

			}
			enter = Validator.getString(scnr, "Do you want to find another book? (Y/N)");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString(scnr, "Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}
		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(chosenBook);
	}
}
