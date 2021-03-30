package SEProjMar9;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * STEP 1: make a new soupAmzn() object TWO COMMANDS: getUrl() and getDocPrice()
 * 
 * @author Evan
 *
 */
public class soupAmzn {
	private Document document;
	private Scanner sc;
	private String asinID;
	private String url;
	private String currPrice;
	private String prevPrice;
	private String cartLink;

	private double dbCurr;
	private double dbPrev;

	double dollarToDouble(String str) {
		if (str == null) {
			return -1;
		}
		
		String stres = new String();
		double result;

		for (int i = 1; i < str.length(); i++) {
			stres += str.charAt(i);
		}

		result = Double.parseDouble(stres);

		return result;
	}

	soupAmzn() {
		sc = new Scanner(System.in);
		asinID = new String();
		url = new String();
	}

	void getURL() {
		System.out.print("Enter Item ASIN ID From Amazon: ");
		asinID = sc.next();
		url = "https://www.amazon.com/gp/product/" + asinID;
		cartLink = "https://www.amazon.com/gp/aws/cart/add.html?&ASIN.1=" + asinID + "&Quantity.1=1";
		// url = sc.next();
	}

	double getDocPrice() {
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		Elements price = document.select("span#price_inside_buybox"); // get price

		for (int i = 0; i < price.size(); i++) {
			prevPrice = currPrice;
			currPrice = price.get(i).text();
			
			if (price.size() != 0) {
				dbPrev = dollarToDouble(prevPrice);
				dbCurr = dollarToDouble(currPrice);
			}

			if (currPrice.equals(prevPrice) || (i == 0)) {
				System.out.print("Price has not changed: ");
				System.out.println(currPrice);
				System.out.println("----LINK----\n" + cartLink + "\n");
			} else {
				System.out.println("");
				System.out.print("PRICE HAS CHANGED: ");
				System.out.println(currPrice);
				System.out.println("----LINK----\n" + cartLink + "\n");
			}
		}
		return dbCurr;
	}

}