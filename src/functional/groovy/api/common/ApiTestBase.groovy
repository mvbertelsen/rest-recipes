package api.common

import org.glassfish.jersey.client.ClientConfig
import org.glassfish.jersey.jackson.JacksonFeature
import org.junit.Before

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.WebTarget

class ApiTestBase {

    protected Client client
    protected WebTarget target

    public ApiTestBase(String targetPath) {
        ClientConfig config = new ClientConfig().register(new JacksonFeature())
        client = ClientBuilder.newClient(config)
        target = client.target("http://localhost:8080/rest-recipes/api").path(targetPath)
    }

}
