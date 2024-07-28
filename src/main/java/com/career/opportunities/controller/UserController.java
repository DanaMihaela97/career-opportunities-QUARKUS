package com.career.opportunities.controller;

import com.career.opportunities.entity.User;
import com.career.opportunities.service.UserService;
import io.smallrye.mutiny.Uni;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @POST
    public Uni<Response> createUser(User user) {
        return userService.createUser(user)
                .onItem().transform(createdUser -> Response.ok(createdUser).status(Response.Status.CREATED).build());
    }
}
