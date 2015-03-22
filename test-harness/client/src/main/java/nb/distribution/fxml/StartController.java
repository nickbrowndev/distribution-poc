package nb.distribution.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nb.distribution.SimpleObjectReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nick on 21/03/15.
 */
public class StartController extends AbstractController {

    private final Logger log = LoggerFactory.getLogger(StartController.class);
    @FXML
    private TextField port;
    @FXML
    private Button startButton;
    @FXML
    private TextArea statusText;

    private Thread serverThread;

    @FXML
    private void onStartButtonClick(ActionEvent event) {
        String portString = port.getText();
        try {
            Integer port = Integer.parseInt(portString);

            if (serverThread == null || serverThread.isInterrupted()) {
                serverThread = new Thread(new SimpleObjectReceiver(port));
            }

        } catch (NumberFormatException e) {
            String errorString = "Invalid port number: " + portString + ". Cause: " + e.getMessage();
            log.error(errorString, e);
            statusText.setText(errorString);
        } catch (Exception e) {
            String errorString = "Unable to open port number: " + portString + ". Cause: " + e.getMessage();
            log.error(errorString, e);
            statusText.appendText("\n" + errorString);
        }
    }

    @FXML
    private void onStopButtonClick(ActionEvent event) {
        try {

            if (serverThread != null) {
                serverThread.interrupt();
            }

        } catch (Exception e) {
            String errorString = "Unable to close server port. Cause: " + e.getMessage();
            log.error(errorString, e);
            statusText.appendText("\n" + errorString);
        }
    }


}
