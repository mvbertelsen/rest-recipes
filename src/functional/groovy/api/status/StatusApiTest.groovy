package api.status

import api.common.ApiTestBase
import groovyx.net.http.RESTClient
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class StatusApiTest extends ApiTestBase {

    @Test
    public void shouldReturnVersion() {

        def response = rest.get(
                path: "${basePath}/v1/status",
                contentType: 'application/json'
        )

        assertThat response.status, equalTo(200)
        assertThat response.data.version, equalTo("1.0")
    }
}
