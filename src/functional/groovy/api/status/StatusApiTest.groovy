package api.status

import api.common.ApiTestBase
import org.junit.Before
import org.junit.Test
import recipes.resources.Status

import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.MediaType

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class StatusApiTest extends ApiTestBase {

    public StatusApiTest()  {
        super("/v1/status")
    }

    @Test
    public void shouldReturnVersion() {
        Status status = target
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke(Status)
        assertThat status.version, equalTo("1.0")
    }
}
