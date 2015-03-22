package nb.distribution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nick on 21/03/15.
 */
public class SimpleObjectReceiver implements Runnable {

    private int port;

    public SimpleObjectReceiver(int port) throws IOException {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                Socket s = serverSocket.accept();
                new Thread(new DistributionConnectionHandler(s, System.out::println));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error starting server socket on port: " + port, e);
        }
    }
}
