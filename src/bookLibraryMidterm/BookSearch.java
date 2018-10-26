package bookLibraryMidterm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookSearch {
		HashMap <String, String> chosenBook = new HashMap<>();//these arrays should be inherited from inventory class
		ArrayList <String> bookAuthor = new ArrayList<>(30);
		ArrayList <String> bookTitle = new ArrayList<>(30);
		Scanner scnr = new Scanner(System.in);
		String regex = "\\wds";
		
		
	public BookSearch() {
		
		
	}
	public void searchByAuthor(String prompt,Scanner scnr) {
		chosenBook.put("Dr. Doom", "How to finally defeat Mr. Fantastic");//test information
		
		System.out.println(prompt);
		String userSearch = scnr.nextLine();
		
		if (userSearch.matches(regex)) {
			try {
			String bookTitle = chosenBook.get(userSearch);
			String bookAuthor = userSearch;
			
			System.out.println("Were you looking for - " + bookTitle + " by " + bookAuthor + "?");
			System.out.println("Add to cart? (Y/N)");
			
			String cartAdd = scnr.nextLine();
			
			if (cartAdd.equalsIgnoreCase("Y")){
				//pass in status of book to be able to determine if it can be checked out if so
				//add current book information to usercart list-type variable
			}
			else if(cartAdd.equalsIgnoreCase("N")){
				System.out.println("Okay, returning to home...");
			}
			}
			catch(Exception e) {
				System.out.println("Sorry but that author did not register to a book currently in our inventory.");
			}
		}
		else {
			System.out.println("Sorry, search could not be completed - Contact Help Desk...");
			System.out.println(userSearch);
		}
	}
	public void searchByTitle() {
		chosenBook.put("Dr. Doom", "How to finally defeat Mr. Fantastic");//test information
		
		String userSearch = scnr.nextLine();
		
		if (userSearch.matches(regex)) {
			if(chosenBook.containsValue(userSearch)) {
				try {
					String bookAuthor = null; //return key to confirmed value for book title.
					String bookTitle = userSearch;
					
					System.out.println("Were you looking for - " + bookTitle + " by " + bookAuthor + "?");
					System.out.println("Add to cart? (Y/N)");
					
					String cartAdd = scnr.nextLine();
					
					if (cartAdd.equalsIgnoreCase("Y")){
						//pass in status of book to be able to determine if it can be checked out if so
						//add current book information to usercart list-type variable
					}
					else if(cartAdd.equalsIgnoreCase("N")){
						System.out.println("Okay, returning to home...");
					}
					}
					catch(Exception e) {
						System.out.println("Sorry but that author did not register to a book currently in our inventory.");
					}
			}
		}
	}
	
	
}
