package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.model.request.ItemRequest;
import com.atheesh.app.ws.model.response.ItemResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("offers")
public class OfferEntryPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<ItemResponse> getAllOffers() {
        return null;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public ItemResponse getOfferById(@PathParam("id") Integer id){
        return null;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    public ItemResponse save(ItemRequest itemRequest) {
        return null;
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, ItemRequest newItemRequest) {
        return true;
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN } )
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return true;
    }
}
