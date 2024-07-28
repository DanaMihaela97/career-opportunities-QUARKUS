package com.career.opportunities.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
