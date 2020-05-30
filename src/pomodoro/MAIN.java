package pomodoro;
import java.util.*;

// to do's:
// - add time limit: timer stops when time reaches limit


class Helper extends TimerTask {
	Time time = new Time();
	int limit;
	
	Helper (int n){
		limit = n;
	}
	
    public void run() {
    	if (time.getTime() != limit) {
    		time.addSec();
    		time.displayTime();
    	} else {
    		System.out.println("Ding! Time's up!");
    		return;
    	}
    }
}

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
		
		Timer pomodoro = new Timer();
		TimerTask task = new Helper(n);
	
		pomodoro.schedule(task, 1000, 1000);
	}
}
