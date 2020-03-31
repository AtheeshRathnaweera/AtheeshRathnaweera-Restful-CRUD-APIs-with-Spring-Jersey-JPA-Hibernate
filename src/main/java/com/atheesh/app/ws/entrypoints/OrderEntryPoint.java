package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.OrderRequest;
import com.atheesh.app.ws.model.response.OrderResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("orders")
public class OrderEntryPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<OrderResponse> getAllOrders() {
        return null;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public OrderResponse getOrderById(@PathParam("id") Integer id){
        return null;
    }


    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    @Path("/cart")
    public List<OrderResponse> saveBulk(List<OrderRequest> orderRequestList) {
        return null;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    public OrderResponse save(OrderRequest orderRequest) {
        return null;
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, OrderRequest newOrderRequest) {
        return true;
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN } )
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return true;
    }
}
