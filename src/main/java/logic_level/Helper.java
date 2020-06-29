package logic_level;

import java.util.TimerTask;

public class Helper extends TimerTask {
    Time time;
    int limit;

    Helper(int n, Time t) {
        limit = n;
        time = t;
    }

    public void run() {
        time.addSec();
        time.displayTime();
    }
}