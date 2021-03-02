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
	
	void getDocPrice() {
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) { 
			// Auto-generated catch block
			e.printStackTrace();
		}
		Elements price = document.select("span#price_inside_buybox"); //get price
		for (int i=0; i < price.size(); i++) {
			System.out.println(price.get(i).text());
			}
	}
}
