package SEProjMar9;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class soupTargetTest {
	public static void main(String args[]){
		print("running...");
		Document document;
		
		Scanner sc = new Scanner(System.in);
		String str = new String();
		
		System.out.print("Enter Item URL From Amazon: ");
		str = sc.next();
		
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect(str).get();
			
			String title = document.title(); //Get title
			print("  Title: " + title); //Print title.
			
			Elements price = document.select("span#price_inside_buybox"); //get price
			for (int i=0; i < price.size(); i++) {
				print(price.get(i).text());
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
		print("done");
	}

	public static void print(String string) {
		System.out.println(string);
	}
}
