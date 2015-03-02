package com.nickbrown;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by nick on 02/03/15.
 */
public class TestHarness extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Distribution Test Harness");

        Button btn = new Button();
        btn.setText("Say 'Hello World!'");
        btn.setOnAction((event) -> {
            System.out.println("Hello World!");
            ;
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

    }
}
