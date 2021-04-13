package testing;

import java.io.IOException;


import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
/** 
 * STEP 1: make a new soupAmzn() object
 * TWO COMMANDS: getUrl() and getDocPrice()
 * @author Evan
 *
 */
public class soupAmzn {
	private Document document;
	private String asinID;
	private String url;
	private String currPrice;
	private String prevPrice;
	private String cartLink;
	
	soupAmzn() {
		
		url = new String();
	}
	
	void getURL() {
		String asinID = JOptionPane.showInputDialog(null, "enter your asin id here");
		
	
		
		System.out.println("your asin id is " + asinID);
		
		url = "https://www.amazon.com/gp/product/" + asinID; 
		cartLink = "https://www.amazon.com/gp/aws/cart/add.html?&ASIN.1=" + asinID + "&Quantity.1=1";
		
	}
	
	void getDocPrice() throws IOException, URISyntaxException {
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) { 
			// Auto-generated catch block
			e.printStackTrace();
		}
		Elements price = document.select("span#price_inside_buybox"); //get price
		
		
		for (int i=0; i < price.size(); i++) {			
			prevPrice = currPrice;
			currPrice = price.get(i).text();
			 
			if (!currPrice.equals(prevPrice) || (i == 0)) {
				System.out.print("Price has not changed: ");
				System.out.println(currPrice);
				
			} 
			else {
				
				
				System.out.println("");
				System.out.print("PRICE HAS CHANGED: ");
				System.out.println(currPrice);
				System.out.println("Link: " + cartLink);
				System.out.println("");
				String end = JOptionPane.showInputDialog(null, "Your price has changed would you like to buy? yes/no");
				
				if (end.equals("yes")) {
					try {
						System.out.println("should open website");
						  Desktop desktop = java.awt.Desktop.getDesktop();
						  URI oURL = new URI(cartLink);
						  desktop.browse(oURL);
						} 
					catch (Exception e) {
						  e.printStackTrace();
						}
			
				}
				
			}			
		}
		
	}

	
}
