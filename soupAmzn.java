package SEProjMar9;

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
	private String currPrice;
	private String prevPrice;
	private String cartLink;
	
	soupAmzn() {
		sc = new Scanner(System.in);
		url = new String();
	}
	
	void getURL() {
		System.out.print("Enter Item URL From Amazon: ");
		
		url = sc.next();
	}
	
	void getDocPrice() {
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) { 
			// Auto-generated catch block
			e.printStackTrace();
		}
		Elements price = document.select("span#price_inside_buybox"); //get price
		Elements asinID = document.select(".a-size-base.prodDetAttrValue");
		
		for (int i=0; i < price.size(); i++) {			
			prevPrice = currPrice;
			currPrice = price.get(i).text();
			 
			if (currPrice.equals(prevPrice) || (i == 0)) {
				System.out.print("Price has not changed: ");
			} else {
				System.out.print("PRICE HAS CHANGED: ");
			}
			// System.out.println(price.get(i).text());
			System.out.println(currPrice);
			}
		System.out.println("*** asinID.size() = " + asinID.size()); // checking to see if it read it
		for (int i = 0; i < asinID.size(); i++) {
			cartLink = asinID.get(i).text();
			System.out.println(cartLink);
		}
	}
}
