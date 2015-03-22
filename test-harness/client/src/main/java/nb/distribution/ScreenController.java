package nb.distribution;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 03/03/15.
 */
public class ScreenController extends StackPane {

    Logger log = LoggerFactory.getLogger(ScreenController.class);

    public ScreenController() {
    }

    public ScreenController(final Scene scene, final ScreenReference... initialScreens) {
        this();
        loadScreens(scene, initialScreens);
    }

    private Map<ScreenReference, Node> screens = new HashMap<>();

    public void loadScreens(final Scene scene, ScreenReference... screens) {
        for (ScreenReference screen : screens) {
            loadScreen(scene, screen);
        }
    }

    public void loadScreen(final Scene scene, final ScreenReference screen) {

        try {
            FXMLLoader myLoader = new
                    FXMLLoader(getClass().getResource(screen.getFxmlFileName()));
            //myLoader.setRoot(scene);
            Parent loadScreen = myLoader.load();

            ControlledScreen myScreenController = myLoader.getController();
            myScreenController.setScreenParent(this);
            addScreen(screen, loadScreen);
        } catch (Exception e) {
            throw new RuntimeException("Error loading screen: " + screen.toString(), e);
        }
    }

    private void addScreen(final ScreenReference screenReference, final Node screen) {
        this.screens.put(screenReference, screen);
    }

    public void setScreen(final Scene scene, final ScreenReference screenReference) {
        if (!screens.containsKey(screenReference)) {
            loadScreen(scene, screenReference);
        }

        if (!getChildren().isEmpty()) {
            getChildren().clear();
        }
        getChildren().add(screens.get(screenReference));
    }

    public boolean unloadScreen(final ScreenReference screenReference) {
        if (screens.remove(screenReference) == null) {
            log.warn("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}
