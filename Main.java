package SEProjMar9;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		
		//testWindow ui = new testWindow("$40.49");
		
		soupAmzn pg = new soupAmzn();
		
		// always ask first 
		pg.getURL();
		System.out.println("Creating URL(s) and connecting...\n");
		
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



