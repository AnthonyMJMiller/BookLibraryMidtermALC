package bookLibraryMidterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

//public static ArrayList<String> modifyName(ArrayList<String> names, int index) {
//	names.set(index, "Grant Chirpus");
//	return names;
//}

public class BookInventory {

	public static ArrayList<Book> bookArray() {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			System.out.println("Works");

			FileReader readTxt = new FileReader("BookDB.txt");
			BufferedReader readbook = new BufferedReader(readTxt);

			int numLines = 5;

			for (int i = 0; i < numLines; i++) {
				int bookID = readbook.read();
				String bookTitle = readbook.readLine();
				String bookAuthor = readbook.readLine();
				String bookStatus = readbook.readLine();
				String dueDate = readbook.readLine();

				// Casting Strings to enum and LocalDate
				BookStatus bookEnum = BookStatus.valueOf(bookStatus);
				LocalDate bookDue = LocalDate.parse(dueDate);

				Book book = new Book(bookID, bookTitle, bookAuthor, bookEnum, bookDue);
			}

		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		return bookList;
	}

}
