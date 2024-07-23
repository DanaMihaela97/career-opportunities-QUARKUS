package com.career.opportunities.controller;

import com.career.opportunities.entity.Job;
import com.career.opportunities.service.JobService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobController  {
    @Inject
    JobService jobService;

    @POST
    public Uni<Response> createJob(Job job) {
        return jobService.createJob(job)
                .onItem().transform(createdJob -> Response.ok(createdJob).status(Response.Status.CREATED).build());
    }

    @GET
    public Uni<List<Job>> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GET
    @Path("/{id}")
    public Uni<Response> getJobById(@PathParam("id") Long id) {
        return jobService.getJobById(id)
                .onItem().transform(jobOpt -> jobOpt
                        .map(job -> Response.ok(job).build())
                        .orElse(Response.status(Response.Status.NOT_FOUND).build()));
    }

    @DELETE
    @Path("/{id}")
    public Uni<Response> deleteJobById(@PathParam("id") Long id) {
        return jobService.deleteJobById(id)
                .onItem().transform(voidItem -> Response.status(Response.Status.NO_CONTENT).build());
    }

}
