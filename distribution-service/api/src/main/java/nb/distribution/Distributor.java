package nb.distribution;


/**
 * Created by nick on 19/03/15.
 */
public interface Distributor {

    public boolean distribute(final Destination destination, final Object object);
}
