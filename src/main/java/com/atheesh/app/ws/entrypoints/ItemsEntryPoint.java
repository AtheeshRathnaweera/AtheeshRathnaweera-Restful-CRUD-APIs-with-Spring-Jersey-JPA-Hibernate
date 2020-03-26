package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("items")
public class ItemsEntryPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public String getAllActiveItems() {
        return "All active items will be received.";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/all")
    public String getAllItems() {
        return "All items will be received.";
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public String save(UserRequest userRequest) {
        return "item will be saved";
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/{id}")
    public UserResponse update(@PathParam("id") String id, UserResponse createUserModel) {
        return new UserResponse();
    }

    @DELETE
    @Consumes({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/{id}")
    public String delete(UserRequest userRequest) {
        return "item will be deleted";
    }




}
