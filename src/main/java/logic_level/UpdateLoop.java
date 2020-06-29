package logic_level;

import gui_level.InterfacePlate;
import javafx.animation.AnimationTimer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateLoop {

    AnimationTimer timer;
    InterfacePlate plate;
    int gear = 0;
    int minutes = 1;

    Events events;

    Time time_clock;

    public UpdateLoop(InterfacePlate _plate) {
        plate = _plate;
        events = new Events(this);
    }

    public void setGear(int _gear) {
        this.gear = _gear;
        if (gear == 2) {
            Timer pomodoro = new Timer();
            TimerTask task = new Helper(minutes, time_clock = new Time());
            pomodoro.schedule(task, 1000, 1000);
        }
    }

    public void start() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long dt) {
                switch (gear) {

                    case 1:
                        plate.display_time.setText(minutes + ":00");
                        plate.display_time.setLayoutX((plate.WIDTH - plate.display_time.getBoundsInParent().getWidth()) / 2);
                        plate.display_time.setLayoutY((plate.HEIGHT - plate.display_time.getLayoutBounds().getHeight()) / 2);
                        break;

                    case 2:
                        plate.display_time.setText(time_clock.displayTime());
                        plate.display_time.setLayoutX((plate.WIDTH - plate.display_time.getBoundsInParent().getWidth()) / 2);
                        plate.display_time.setLayoutY((plate.HEIGHT - plate.display_time.getLayoutBounds().getHeight()) / 2);

                        events.TimerTaskEvent();
                        break;

                    case 3:
                        plate.display_time.setText("" +
                                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" +
                                Calendar.getInstance().get(Calendar.MINUTE));
                        plate.display_time.setLayoutX((plate.WIDTH - plate.display_time.getBoundsInParent().getWidth()) / 2);
                        plate.display_time.setLayoutY((plate.HEIGHT - plate.display_time.getBoundsInLocal().getHeight()) / 2);
                        break;

                }
            }
        };
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
