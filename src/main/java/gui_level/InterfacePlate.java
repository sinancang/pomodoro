package gui_level;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic_level.UpdateLoop;

public class InterfacePlate extends Application {

    UpdateLoop loop;

    public Label display_time;
    public Button start_button;

    public int WIDTH = 500;
    public int HEIGHT = 300;
    public int PAD = 300;

    @Override
    public void start(Stage stage) {
        loop = new UpdateLoop(this);

        display_time = new Label();
        display_time.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 100));

        start_button = new Button("Start!");
        start_button.setOnMouseClicked(event -> {
            loop.setGear(2);
            start_button.setDisable(true);
        });

        AnchorPane anchor = new AnchorPane(start_button);
        AnchorPane.setTopAnchor(start_button, 250.0);
        AnchorPane.setLeftAnchor(start_button, 430.0);

        Group parent = new Group(display_time, anchor);

        Scene scene = new Scene(parent, WIDTH, HEIGHT);
        stage.setScene(scene);

        loop.setGear(1);
        loop.start();
        stage.show();

    }

    @Override
    public void stop() {
        loop.stop();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
