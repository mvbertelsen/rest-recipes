package api.status

import org.glassfish.jersey.client.ClientConfig
import org.glassfish.jersey.jackson.JacksonFeature
import org.junit.Test
import recipes.resources.Status

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.MediaType
import javax.xml.ws.Response

import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.is as IS

class StatusApiTest {

    @Test
    public void shouldReturnVersion() {
        ClientConfig config = new ClientConfig().register(new JacksonFeature())
        Client client = ClientBuilder.newClient(config)
        WebTarget target = client.target("http://localhost:8080/rest-recipes/api/status")
        Status status = target
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke(Status)
        assertThat status.version, IS("1.0")
    }
}
