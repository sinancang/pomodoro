package pomodoro;
import java.util.*;

// run redefined to add one second to the time and display it.
class Helper extends TimerTask {
	Time time;
	int limit;
	
	Helper (int n, Time t){
		limit = n;
		time = t;
	}
	
    public void run() {
    	time.addSec();
    	time.displayTime();
    }
}

// Time object to keep track of time passed
class Time {
	int[] time = new int[] {0,0,0,0};
	boolean up = false;
	
	public void displayTime() {
		System.out.println(time[0] + "" + time[1] + "." + time[2] + time[3]);
	}
	
	public void addSec() {
		time[3]++;
		if (time[3] == 10) {
			time[3] = 0;
			time[2]++;
		}
		
		if (time[2] == 6) {
			time[2] = 0;
			time[1]++;
		}
		
		if (time[1] == 10) {
			time[1] = 0;
			time[0]++;
		}
	}
	
	// getTime only needs to return the minute part of time
	public int getTime() {
		String s1 = Integer.toString(time[0]);
		String s2 = Integer.toString(time[1]);
		
		String s = s1 + s2;
		
		int c = Integer.parseInt(s);
		return c;
	}
}


public class MAIN {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("For how long should the timer go? (in mins)");
		
		int n = sc.nextInt();
		sc.close();
		
		Time t = new Time();
		
		Timer pomodoro = new Timer();
		TimerTask task = new Helper(n, t);
		// scheduled to execute run() every 1 second, after an initial 1 second
		pomodoro.schedule(task, 1000, 1000);
		
		// constant check if time is up
		while (true) {
			// cancels timer when time limit reached
			if (t.getTime() == n) {
				pomodoro.cancel();
				System.out.println("Ding! Time's up!");
				break;
			}
		}
	}
}
