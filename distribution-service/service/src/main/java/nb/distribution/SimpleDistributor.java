package nb.distribution;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

/**
 * Created by nick on 20/03/15.
 */
public class SimpleDistributor implements Distributor {

    public boolean distribute(final URI destination, final Object object) throws UnknownHostException, IOException {
        Socket s = new Socket(destination.getHost(), destination.getPort());
        ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
        os.writeObject(object);
        return true;
    }

}
