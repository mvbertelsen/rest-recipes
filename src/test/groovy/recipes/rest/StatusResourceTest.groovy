package recipes.rest

import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

class StatusResourceTest {

    private StatusResource statusResource = new StatusResource();

    @Test
    public void getStatusReturnsVersion() {
        assertThat statusResource.status.version, equalTo("1.0")
    }
}
