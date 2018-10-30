package bookLibraryMidterm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	private int bookID;
	private String bookAuthor;
	private String bookTitle;
	private BookStatus bookStatus;
	private LocalDate bookDue;
	
	//overloaded constructor to allow book to contain due date (bookDue)
	public Book (int bookID, String bookTitle, String bookAuthor, BookStatus bookStatus, LocalDate bookDue) {
		this.bookID = bookID;
		this.bookAuthor = bookAuthor;
		this.bookTitle = bookTitle;
		this.bookStatus = bookStatus;
		this.bookDue = bookDue;
	}

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public LocalDate getBookDue() {
		return bookDue;
	}

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	public void setBookDue(LocalDate bookDue) {
		this.bookDue = bookDue;
	}

	@Override
	public String toString() {
		return  bookID + "," + bookTitle + "," + bookAuthor + ","
				+ bookStatus + "," + bookDue.format(formatter) + "\n";
	}

}
