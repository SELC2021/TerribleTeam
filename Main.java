package testing;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		
		ParseGuide pg = new ParseGuide();
		
		// always ask first 
		pg.getURL();
		
		// creating timer task, timer
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		    public void run() {
		    pg.getDocPrice();
		    //function that checks to see if the price is right or not 
		    }
		    }, 500, 1000 );
		      
	}
}



