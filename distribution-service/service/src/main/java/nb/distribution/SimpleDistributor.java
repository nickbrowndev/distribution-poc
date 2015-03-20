package nb.distribution;

/**
 * Created by nick on 20/03/15.
 */
public class SimpleDistributor implements Distributor {

    public boolean distribute(final Destination destination, final Object object) {
        return true;
    }
}
