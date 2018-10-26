package bookLibraryMidterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

//public static ArrayList<String> modifyName(ArrayList<String> names, int index) {
//	names.set(index, "Grant Chirpus");
//	return names;
//}

public class BookInventory {

	private static Path filePath = Paths.get("books.txt");
	private static File bookDBFile = filePath.toFile();

	public static ArrayList<Book> bookArray() {


		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			FileReader readTxt = new FileReader(bookDBFile);
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
				// System.out.println(bookID + " " + bookTitle + " " + bookAuthor + " " +
				// bookEnum + " " + bookDue);
				line = readbook.readLine();

			}
			System.out.println(bookList.toString());
			readbook.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return bookList;

	}
}
