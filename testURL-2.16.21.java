package gethtml;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class testURL {
	public static void main(String[] args) {
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;

	    try {
	        url = new URL("https://www.target.com/p/baby-banana-infant-teething-toothbrush/-/A-15993444");
	        is = url.openStream(); // connect to url
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) { // buffered reader
	            System.out.println(line); // prints line-by-line the html
	        }
	    } catch (MalformedURLException mue) { // a bunch of catches if it fails, i don't understand these
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing
	        }
	    }
	}
}
