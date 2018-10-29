package bookLibraryMidterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class BookInventory {

	private static Path filePath = Paths.get("books.txt");
	private static File bookInventoryFile = filePath.toFile();
	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Book> bookList = new ArrayList<Book>();


	public static ArrayList<Book> bookArray() {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			FileReader readTxt = new FileReader(bookInventoryFile);
			BufferedReader readbook = new BufferedReader(readTxt);

			String[] bookInfo = new String[5];

			String line = readbook.readLine();

			while (line != null) {
				bookInfo = line.split(",");

				// Casting Strings to enum and LocalDate
				int bookID = Integer.parseInt(bookInfo[0]);
				BookStatus bookEnum = BookStatus.valueOf(bookInfo[3]);
				LocalDate bookDue = LocalDate.parse(bookInfo[4]);

				Book book = new Book(bookID, bookInfo[1], bookInfo[2], bookEnum, bookDue);
				bookList.add(book);

				line = readbook.readLine();

			}
			readbook.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return bookList;
	}

	public static void listBooks(ArrayList<Book> bookList) {
		System.out.printf("\n%-4s %-28s %-24s %-5s\n", "ID", "Title", "Author", "Status");
		System.out.println("------------------------------------------------------------------");

		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);

			System.out.printf("\n%-5d%-30s%-25s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
					b.getBookStatus());
		}
		System.out.println("\n");
	}

	public static void bookCheckout(ArrayList<Book> bookList) {

		int index = Validator.getInt(scnr, "Which book would you like to check out? (please enter the book ID) ");

		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);
			if (b.getBookID() == (index)) {
				if (b.getBookStatus() == BookStatus.INLIBRARY) {
					b.setBookStatus(BookStatus.CHECKEDOUT);
					LocalDate due = LocalDate.now();
					b.setBookDue(due.plusDays(14));
					System.out.println("\nYou have successfully checked out " + b.getBookTitle() + ". "
							+ "Your due date is " + b.getBookDue() + ".\n");

					writeBooksTxt(bookList);

				} else {
					System.out.println("\nSorry, this book is unavailable.\n");
				}
			}
		}
	}

	public static void bookReturn(ArrayList<Book> bookList) {
		listBooks(bookList);

		int index = Validator.getInt(scnr, "\nWhich book would you like to return? (please enter the book ID) ");

		for (int i = 0; i < bookList.size(); i++) {
			Book bReturn = bookList.get(i);
			if (bReturn.getBookID() == (index)) {
				bReturn.setBookStatus(BookStatus.INLIBRARY);
				bReturn.setBookDue(LocalDate.now());
				System.out.println("\nYou have successfully returned " + bReturn.getBookTitle() + ".\n");
				// Change Book Status to INLIBRARY in Text File
				writeBooksTxt(bookList);
			} else if (bReturn.getBookStatus() == (BookStatus.CHECKEDOUT)) {
				System.out.println("Sorry, this book cannot be returned.");
			}
		}
	}

	public static void writeBooksTxt(ArrayList<Book> bookList) {

		try {
			// clean this up--these are declared above. this for testing
			Path filePath = Paths.get("books.txt");
			File bookInventoryFile = filePath.toFile();
			PrintWriter out = new PrintWriter(new FileOutputStream(bookInventoryFile));

			for (int i = 0; i < bookList.size(); i++) {
				String record = bookList.get(i).getBookID() + "," + bookList.get(i).getBookTitle() + ","
						+ bookList.get(i).getBookAuthor() + "," + bookList.get(i).getBookStatus() + ","
						+ bookList.get(i).getBookDue() + "\r\n";
				out.write(record);
			}

			out.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
