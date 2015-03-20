package nb.distribution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class SimpleDistributorTest {

    private SimpleDistributor distributor;

    @Before
    public void setUp() {
        distributor = new SimpleDistributor();
    }

    @Test
    public void shouldSendObjectToDestination() {
        Destination destination = mock(Destination.class);
        assertTrue(distributor.distribute(destination, new Object()));
    }

}