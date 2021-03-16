package SEProjMar9;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		
		soupAmzn pg = new soupAmzn();
		
		// always ask first 
		pg.getURL();
		
		// creating timer task, timer
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		    public void run() {
		    pg.getDocPrice();
		    //function that checks to see if the price is right or not 
		    }
		    }, 100, 500 );
		      
	}
}



