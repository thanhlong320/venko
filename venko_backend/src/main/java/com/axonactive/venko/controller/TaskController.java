package com.axonactive.venko.controller;

import com.axonactive.venko.controller.request.ItemRequest;
import com.axonactive.venko.controller.request.TaskRequest;
import com.axonactive.venko.service.ItemService;
import com.axonactive.venko.service.TaskService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items/{itemId}/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {
    @Inject
    private TaskService taskService;

    @POST
    public Response add(TaskRequest taskRequest, @PathParam("itemId") Integer itemId){
        return Response.ok(taskService.add(taskRequest, itemId)).build();
    }

    @PUT
    @Path("/{taskId}")
    public Response update(TaskRequest taskRequest, @PathParam("taskId") Integer taskId, @PathParam("itemId") Integer itemId){
        return Response.ok(taskService.update(taskRequest, taskId, itemId)).build();
    }

    @DELETE
    @Path("/{taskId}")
    public Response delete( @PathParam("taskId") Integer taskId, @PathParam("itemId") Integer itemId){
        taskService.delete(taskId, itemId);
        return Response.ok().build();
    }
}