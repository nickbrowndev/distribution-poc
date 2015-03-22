package nb.distribution;


import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;

/**
 * Created by nick on 19/03/15.
 */
public interface Distributor {

    public boolean distribute(final URI destination, final Object object) throws UnknownHostException, IOException;
}
