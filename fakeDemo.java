package testing;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class fakeDemo {
	public static void main(String[] args) {
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    String asinID = "hello";

	    try {
	        url = new URL("https://www.amazon.com/gp/product/" + asinID);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
	}
}




















