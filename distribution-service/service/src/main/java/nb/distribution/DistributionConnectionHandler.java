package nb.distribution;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Created by nick on 21/03/15.
 */
public class DistributionConnectionHandler implements Runnable {

    private final Socket socket;
    private Consumer<Object> objectHandler;

    public DistributionConnectionHandler(final Socket socket, final Consumer<Object> objectHandler) {
        this.socket = socket;
        this.objectHandler = objectHandler;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            Object result = is.readObject();
            objectHandler.accept(result);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from socket", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not read object from socket", e);
        }
    }
}
