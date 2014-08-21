package org.superbiz.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("date")
@Produces(MediaType.APPLICATION_JSON)
public interface DateService {
    @GET
    @Path("now")
    Response now();

    @GET
    @Path("zero")
    Response zero();
}
