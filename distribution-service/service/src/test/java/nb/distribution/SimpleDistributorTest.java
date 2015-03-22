package nb.distribution;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleDistributorTest {

    private SimpleDistributor distributor;

    @BeforeMethod
    public void setUp() {
        distributor = new SimpleDistributor();
    }

    @Test
    public void shouldSendObjectToDestination() throws Exception {
        //assertTrue(distributor.distribute(new URI("test://localhost:80/"), new Object()));
    }


}