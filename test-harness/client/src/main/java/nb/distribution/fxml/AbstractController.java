package nb.distribution.fxml;

import nb.distribution.ControlledScreen;
import nb.distribution.ScreenController;

/**
 * Created by nick on 21/03/15.
 */
public class AbstractController implements ControlledScreen {

    private ScreenController screenController;

    @Override
    public void setScreenParent(ScreenController screenController) {
        this.screenController = screenController;
    }
}
