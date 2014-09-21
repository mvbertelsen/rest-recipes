package recipes.rest

import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is as IS

class StatusResourceTest {

    private StatusResource statusResource = new StatusResource();

    @Test
    public void getStatusReturnsVersion() {
        assertThat statusResource.status.version, IS("1.0")
    }
}
