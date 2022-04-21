package com.axonactive.venko.controller;

import com.axonactive.venko.controller.request.ItemRequest;
import com.axonactive.venko.entity.Item;
import com.axonactive.venko.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @Inject
    private ItemService itemService;

    @GET
    public Response findAll(){
        return Response.ok(itemService.findAll()).build();
    }

    @POST
    public Response add(Item item){
        return Response.ok(itemService.add(item)).build();
    }

    @PUT
    public Response update(Item item){
        return Response.ok(itemService.update(item)).build();
    }

    @DELETE
    @Path("/{itemId}")
    public Response delete(@PathParam("itemId") Integer itemId){
        itemService.delete(itemId);
        return Response.ok().build();
    }
}
