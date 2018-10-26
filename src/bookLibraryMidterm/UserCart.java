package bookLibraryMidterm;

import java.util.HashMap;
import java.util.Iterator;

public class UserCart {
	//these arrays should be inherited from inventory class
	HashMap <String, String> chosenBooks = new HashMap<>();
	HashMap <String, String> userCart = new HashMap<>();
	
	public void setCart(String bookAuthor, String bookTitle) {
		for (int i = 0; i < chosenBooks.size(); i++) {
			userCart.put(bookTitle, bookTitle);
		}
		
	}
	public String cartCheckout() {
		String myOrder = null;
		
		for (String browse : chosenBooks.values()) {
			myOrder = browse;
		}
		return myOrder;
		//should return all books within cart hashmap as strings to display a final cart to user
	}
}
