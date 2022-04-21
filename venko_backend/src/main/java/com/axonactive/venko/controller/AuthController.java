package com.axonactive.venko.controller;

import com.axonactive.venko.controller.request.AuthRequest;
import com.axonactive.venko.service.AuthService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    private AuthService authService;

    @POST
    @Path("/login")
    public Response login(AuthRequest userRequest){
        return Response.ok(authService.login(userRequest)).build();
    }
}
