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

//public static ArrayList<String> modifyName(ArrayList<String> names, int index) {
//	names.set(index, "Grant Chirpus");
//	return names;
//}

public class BookInventory {

	private static Path filePath = Paths.get("books.txt");
	private static File bookInventoryFile = filePath.toFile();
	static Scanner scnr = new Scanner(System.in);

	public static ArrayList<Book> bookArray() {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			FileReader readTxt = new FileReader(bookInventoryFile);
			// LineNumberReader linesNum = new LineNumberReader(readTxt);
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
			// System.out.println(bookList.toString());
			readbook.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return bookList;
	}

	public static void listBooks(ArrayList<Book> bookList) {
		// ArrayList<Book> bookList = BookInventory.bookArray();
		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);
			System.out.printf("\n%-12d%-30s%-30s%-12s", b.getBookID(), b.getBookTitle(), b.getBookAuthor(),
					b.getBookStatus());
		}
		String choice = Validator.getString(scnr, "\nWould you like to checkout one of these items? y/n ");

		if (choice.equalsIgnoreCase("y")) {
			bookCheckout(bookList);
		} else {
			System.out.println("false?");
		}

	}

	public static void bookCheckout(ArrayList<Book> bookList) {
		// change method so scanner not redeclared everywhere
		int index = Validator.getInt(scnr, "Which book would you like to check out? (please enter the book ID) ");

		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);
			if (b.getBookID() == (index)) {
				if (b.getBookStatus() == BookStatus.INLIBRARY) {
					b.setBookStatus(BookStatus.CHECKEDOUT);
					LocalDate due = LocalDate.now();
					b.setBookDue(due.plusDays(14));
					System.out.println("Successfully checked out and due on " + b.getBookDue());

				} else {
					System.out.println("Sorry, this book is unavailable.");
				}
			}
		}
	}

	public static void bookReturn() {
		int index = Validator.getInt(scnr, "Which book would you like to return? (please enter the book ID) ");

		ArrayList<Book> bookList = BookInventory.bookArray();

		for (int i = 0; i < bookList.size(); i++) {
			Book bReturn = bookList.get(i);
			if (bReturn.getBookID() == (index)) {
				bReturn.setBookStatus(BookStatus.INLIBRARY);
				bReturn.setBookDue(null);
				System.out.println("Successfully returned " + bReturn.getBookTitle());
			} else {
				System.out.println("Sorry, this book cannot be returned.");
			}
		}
	}

	public static void writeBooksTxt(ArrayList<Book> bookList) {

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(bookInventoryFile));

			for (int i = 0; i < bookList.size(); i++) {
				String record = bookList.get(i).getBookID() + "," + bookList.get(i).getBookTitle() + ","
						+ bookList.get(i).getBookAuthor() + "," + bookList.get(i).getBookStatus() + "\r\n";
				// System.out.println(record);
				out.write(record);

			}

			out.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
