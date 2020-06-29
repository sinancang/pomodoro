package logic_level;

public class Time {
    int[] time = new int[]{0, 0, 0, 0};
    boolean up = false;

    public String displayTime() {
        String out = time[0] + "" + time[1] + "." + time[2] + time[3];
        System.out.print("\b\b\b\b\b" + out);
        return out;
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


    /**
     * This function returns spent time in minutes
     * @return Minutes
     */
    public int getTime() {
        String s1 = Integer.toString(time[0]);
        String s2 = Integer.toString(time[1]);

        String s = s1 + s2;

        int c = Integer.parseInt(s);
        return c;
    }
}
