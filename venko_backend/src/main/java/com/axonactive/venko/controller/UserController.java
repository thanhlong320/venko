package com.axonactive.venko.controller;

import com.axonactive.venko.controller.request.UserRequest;
import com.axonactive.venko.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @POST
    @Path("/register")
    public Response register(UserRequest userRequest){
        return Response.ok(userService.register(userRequest)).build();
    }
}
