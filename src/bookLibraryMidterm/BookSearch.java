package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch {
	static ArrayList<Book> bookList = BookInventory.bookArray();
	static Scanner scnr = new Scanner(System.in);



	public BookSearch() {

	}

	public static void searchByAuthor() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
			String userSearch = Validator.getString(scnr, "Please enter author name: ");
			
				System.out.printf("\n%-4s %-28s %-24s %-5s\n", "ID", "Title", "Author", "Status");
				System.out.println("------------------------------------------------------------------");

				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					if (BookInventory.bookArray().get(i).getBookAuthor().contains(userSearch)) {
						Book b = bookList.get(i);

						System.out.printf("\n%-5d%-30s%-25s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
								b.getBookStatus());
						// bookList.add(BookInventory.bookArray().get(i));
						tryAgain = false;
					}

				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

		} 
			enter = Validator.getString(scnr, "\nDo you want to find another book? (Y/N) ");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString(scnr, "Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}

		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(bookList);
	}

	public static void searchByTitle() {
		boolean tryAgain = true;
		String enter;
		do {
			while (tryAgain) {
				String userSearch = Validator.getString(scnr, "Please enter title name: ");
				System.out.printf("\n%-4s %-28s %-24s %-5s\n", "ID", "Title", "Author", "Status");
				System.out.println("------------------------------------------------------------------");
				for (int i = 0; i < BookInventory.bookArray().size(); i++) {
					if(BookInventory.bookArray().get(i).getBookTitle().contains(userSearch)) {
						Book b = bookList.get(i);

						System.out.printf("\n%-5d%-30s%-25s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
								b.getBookStatus());
						// bookList.add(BookInventory.bookArray().get(i));
						tryAgain = false;
					} 
				}
				if (tryAgain) {
					System.out.println("No matches! Please try again.");
				}

			}
			enter = Validator.getString(scnr, "\nDo you want to find another book? (Y/N) ");
			while (!enter.equalsIgnoreCase("Y") && !enter.equalsIgnoreCase("N")) {
				enter = Validator.getString(scnr, "Error! Please type Y or N: ");
			}
			if (enter.equalsIgnoreCase("Y")) {
				tryAgain = true;
			}
		} while (enter.equalsIgnoreCase("Y"));
		
		BookInventory.bookCheckout(bookList);
	}
}
