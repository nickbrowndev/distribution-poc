package nb.distribution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nick on 19/03/15.
 */
public class Destination {

    private static final Logger log = LoggerFactory.getLogger(Destination.class);

    private String uri;
    private int port;

    public Destination(final String uri, final int port) {
        this.uri = uri;
        this.port = port;

    }

    public String getUri() {
        return uri;
    }

    public int getPort() {
        return port;
    }


}
