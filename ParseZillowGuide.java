package testing;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * This class is used for HTML parsing from URL using Jsoup.
 * @author
 */

public class ParseZillowGuide {
	public static void main(String args[]){
		print("running...");
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("https://www.amazon.com/Dupadstory-Silicone-Training-Toothbrush-Teether/dp/B07H7GW4QL/ref=sr_1_1_sspa?crid=1PFVF85U7AYMI&dchild=1&keywords=banana+baby+toothbrush&qid=1614194588&sprefix=bannana+baby%2Caps%2C167&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyRERaV1JGMjNUSU05JmVuY3J5cHRlZElkPUEwOTQwODk2MUNMQUJBRUsyRk85SCZlbmNyeXB0ZWRBZElkPUEwNzQzMzY2TEZLNUtXMEdKQkVVJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==").get();

			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.

			Elements price = document.select("span#price_inside_buybox"); //Get price
		
			//Print price
			print("  Price: " + price);
			for (int i=0; i < price.size(); i++) {
				print(price.get(i).text());
				}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
	}

	public static void print(String string) {
		System.out.println(string);
	}
}
