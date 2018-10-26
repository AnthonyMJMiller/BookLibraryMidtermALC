package bookLibraryMidterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

//public static ArrayList<String> modifyName(ArrayList<String> names, int index) {
//	names.set(index, "Grant Chirpus");
//	return names;
//}

public class BookInventory {

	private static Path filePath = Paths.get("BookDB.txt");
	private static File bookDBFile = filePath.toFile();

	public static ArrayList<Book> bookArray() {


		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			FileReader readTxt = new FileReader(bookDBFile);
			LineNumberReader linesNum = new LineNumberReader(readTxt);
			BufferedReader readbook = new BufferedReader(readTxt);

//			linesNum.skip(Long.MAX_VALUE);
//			// add 1 becuase LineNumberReader starts at 0
//			long lengthLines = linesNum.getLineNumber();
//			linesNum.close();
//			int numLines = 5;
//
//			long loopnum = lengthLines / numLines;

			for (int i = 0; i < 3; i++) {


				String idString = readbook.readLine();
				String bookTitle = readbook.readLine();
				String bookAuthor = readbook.readLine();
				String bookStatus = readbook.readLine();
				String dueDate = readbook.readLine();


				// Casting Strings to enum and LocalDate
				int bookID = Integer.parseInt(idString);
				BookStatus bookEnum = BookStatus.valueOf(bookStatus);
				LocalDate bookDue = LocalDate.parse(dueDate);


				Book book = new Book(bookID, bookTitle, bookAuthor, bookEnum, bookDue);
				bookList.add(book);
				// System.out.println(bookID + " " + bookTitle + " " + bookAuthor + " " +
				// bookEnum + " " + bookDue);

			}
			System.out.println(bookList.toString());
			readbook.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return bookList;

	}
}
