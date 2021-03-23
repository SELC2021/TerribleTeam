package testWeb;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/** 
 * STEP 1: make a new soupAmzn() object
 * TWO COMMANDS: getUrl() and getDocPrice()
 * @author Evan
 *
 */
public class soupAmzn {
	private Document document;
	private Scanner sc;
	private String url;
	
	soupAmzn() {
		sc = new Scanner(System.in);
		url = new String();
	}
	
	void getURL() {
		System.out.print("Enter Item URL From Amazon: ");
		url = sc.next();
	}
	
	int getDocPrice() {
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) { 
			// Auto-generated catch block
			e.printStackTrace();
		}
		Elements price = document.select("span#price_inside_buybox"); //get price
<<<<<<< Updated upstream
		for (int i=0; i < price.size(); i++) {
			System.out.println(price.get(i).text());
			}
	}
}
=======
		
		for (int i=0; i < price.size(); i++) {			
			prevPrice = currPrice;
			currPrice = price.get(i).text();
			 
			if (currPrice.equals(prevPrice) || (i == 0)) {
				System.out.print("Price has not changed: ");
				System.out.println(currPrice);
				//System.out.println("Link: " + cartLink);
			} else {
				System.out.println("");
				System.out.print("PRICE HAS CHANGED: ");
				System.out.println(currPrice);
				System.out.println("Link: " + cartLink);
				System.out.println("");
			}			
		}
		return 0;
	}
	
}
>>>>>>> Stashed changes
