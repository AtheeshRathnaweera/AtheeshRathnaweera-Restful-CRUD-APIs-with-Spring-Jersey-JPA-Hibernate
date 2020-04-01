package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.OrderRequest;
import com.atheesh.app.ws.model.response.OrderResponse;
import com.atheesh.app.ws.service.OrderService;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("orders")
public class OrderEntryPoint {

    @Autowired
    OrderService orderService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<OrderResponse> getAllOrders() {
        List<OrderDTO> orderDTOList = orderService.getAllOrders();
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(OrderDTO orderDTO : orderDTOList){
            orderResponseList.add(DTOToResponseFactory.order(orderDTO));
        }
        return orderResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public OrderResponse getOrderById(@PathParam("id") Integer id){
        return DTOToResponseFactory.order(orderService.getOderById(id));
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/user/{id}")
    public List<OrderResponse> getOrdersByUser(@PathParam("id") Integer userId){
        List<OrderDTO> orderDTOList = orderService.getOrdersByUser(userId);
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(OrderDTO orderDTO : orderDTOList){
            orderResponseList.add(DTOToResponseFactory.order(orderDTO));
        }
        return orderResponseList;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON  })
    @Produces({ MediaType.APPLICATION_JSON  })
    public OrderResponse save(OrderRequest orderRequest) {
        OrderDTO orderDTO = orderService.save(RequestToDTOFactory.order(orderRequest));
        return DTOToResponseFactory.order(orderDTO);
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
        return orderService.delete(id);
    }
}
