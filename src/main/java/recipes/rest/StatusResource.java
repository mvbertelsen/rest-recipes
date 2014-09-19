package recipes.rest;

import recipes.resources.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
public class StatusResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Status getStatus() {
        Status status = new Status();
        status.setVersion("1.0");
        return status;
    }
}
