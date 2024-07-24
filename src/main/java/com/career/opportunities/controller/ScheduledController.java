package com.career.opportunities.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/dana")
public class ScheduledController {
    private static final Logger LOGGER = Logger.getLogger(ScheduledController.class.getName());

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJobStatus() {
        LOGGER.info("GET /jobs endpoint accessed");
        return Response.ok("Job is running every 5 seconds").build();
    }
}
