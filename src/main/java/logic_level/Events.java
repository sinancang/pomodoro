package logic_level;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.awt.*;
import java.util.Optional;

public class Events {

    UpdateLoop loop;

    public Events(UpdateLoop _loop) {
        loop = _loop;
    }

    public void TimerTaskEvent() {

        if (loop.minutes == loop.time_clock.getTime()) {
            loop.gear = 1;
            loop.plate.start_button.setDisable(false);
            Toolkit.getDefaultToolkit().beep();
            new Alert(Alert.AlertType.INFORMATION, "Ding! Time's up!", ButtonType.OK).show();
        }

    }

}
