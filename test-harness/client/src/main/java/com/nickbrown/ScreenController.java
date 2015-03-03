package com.nickbrown;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 03/03/15.
 */
public class ScreenController extends StackPane {


    public ScreenController() {
    }

    public ScreenController(ScreenReference... initialScreens) {
        this();
        loadScreens(initialScreens);
    }

    private Map<ScreenReference, Node> screens = new HashMap<>();

    public void loadScreens(ScreenReference... screens) {
        for (ScreenReference screen : screens) {
            loadScreen(screen);
        }
    }

    public void loadScreen(ScreenReference screen) {

        try {
            FXMLLoader myLoader = new
                    FXMLLoader(getClass().getResource(screen.getFxmlFileName()));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenController =
                    ((ControlledScreen) myLoader.getController());
            myScreenController.setScreenParent(this);
            addScreen(screen, loadScreen);
        } catch (Exception e) {
            throw new RuntimeException("Error loading screen: " + screen.toString(), e);
        }
    }

    private void addScreen(final ScreenReference screenReference, final Node screen) {
        this.screens.put(screenReference, screen);
    }

    public void setScreen(final ScreenReference screenReference) {
        if (!screens.containsKey(screenReference)) {
            loadScreen(screenReference);
        }

        if (!getChildren().isEmpty()) {
            getChildren().clear();
        }
        getChildren().add(screens.get(screenReference));
    }

    public boolean unloadScreen(final ScreenReference screenReference) {
        if (screens.remove(screenReference) == null) {
            System.out.println("Screen didn't exist"); // TODO logging
            return false;
        } else {
            return true;
        }
    }
}
