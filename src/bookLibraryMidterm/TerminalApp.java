package bookLibraryMidterm;
import java.util.Scanner;
public class TerminalApp {
	static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {
		//Inherit info from book class, like variables?
		greetUser("Welcome to the DPL Library Terminal. How may i help you today?",scnr);
	}
	public static void greetUser(String prompt, Scanner scnr) {
		System.out.println(prompt);
		System.out.println("Terminal Key: 1-Display Current Inventory. 2-Search for a Book. 3-Check out a book. 4-Return a Book. ");
		
		int accessIDCheck = scnr.nextInt();
		boolean isValid = false; 
		int accessID = 0;
		
		do {
			if (accessIDCheck <= 4) {
				accessID = accessIDCheck;
				isValid = true;
			}
			else if(accessIDCheck <= 0)  {
				System.out.println("Sorry this is not a valid terminal key, please try again or contact help desk");
			}
			else if(accessIDCheck > 4 ) {
				System.out.println("Sorry this is not a valid terminal key, please try again or contact help desk");
			}
		}while(!isValid);
		
		switch(accessID) {
		
		case 1:
			currentInv();
			break;
		case 2:
			bookSearch();
			break;
		case 3:
			bookCheckout();
			break;
		case 4:
			bookReturn();
			break;
		}
	}
	public static void currentInv() {
		//method call to inventory class to receive list of books from text file.
		System.out.println("FUNCTIONING!");
	}
	public static void bookSearch() {
		BookSearch bs = new BookSearch();
		
		System.out.println("Would you like to search by author or by title?");
		System.out.println("Key: 1-Author. 2-Title.");
		int userInput = scnr.nextInt();
		scnr.nextLine();
		
		switch(userInput) {
		case 1:
			bs.searchByAuthor("Please enter the author name of the book you are looking for",scnr);
			break;
		case 2:
			bs.searchByTitle();
			break;
		}
	}
	public static void bookCheckout() {
		//method call to UserCart that will provide functions to store books from List-Type variable into another List Type that will hold the books 
		//user wants to check out
		System.out.println("FUNCTIONING!");
	}
	public static void bookReturn() {
		//method call to Return class that will change the status of a book from checked-in to checked-out.
		System.out.println("FUNCTIONING!");
	}
	

}
