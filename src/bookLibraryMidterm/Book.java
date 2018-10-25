package bookLibraryMidterm;

public class Book {
	
	private int bookID;
	private String bookTitle;
	private String bookAuthor;
	private String bookStatus;
	private String bookDue;

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public String getBookDue() {
		return bookDue;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public void setBookDue(String bookDue) {
		this.bookDue = bookDue;
	}

}
