package nb.distribution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by nick on 19/03/15.
 */
public class Destination {

    private static final Logger log = LoggerFactory.getLogger(Destination.class);

    private URI uri;

    public Destination(final String uri) {

        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            log.error("Error creating URI for '{}'", uri, e);
            throw new RuntimeException("Error creating uri for '" + uri + "'", e);
        }

    }


}
