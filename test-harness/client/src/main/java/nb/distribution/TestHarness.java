package nb.distribution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by nick on 02/03/15.
 *
 * Tset commit
 */
public class TestHarness extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Distribution Test Harness");

        ScreenController sc = new ScreenController();
        Scene containerScene = new Scene(sc);

        sc.setScreen(containerScene, new ScreenReference("start"));

        primaryStage.setScene(containerScene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);


        primaryStage.show();
    }
}
