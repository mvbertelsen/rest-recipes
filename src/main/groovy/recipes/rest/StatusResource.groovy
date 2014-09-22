package recipes.rest;

import recipes.resources.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path('/v1/status')
public class StatusResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Status getStatus() {
        new Status( version: '1.0')
    }
}
