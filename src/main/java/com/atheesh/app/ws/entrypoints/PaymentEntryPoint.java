package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.model.request.PaymentRequest;
import com.atheesh.app.ws.model.response.PaymentResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("payments")
public class PaymentEntryPoint {

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<PaymentResponse> getAllPayments() {
        return null;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public PaymentResponse getPaymentById(@PathParam("id") Integer id){
        return null;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/order/{id}")
    public PaymentResponse getPaymentByOrderId(@PathParam("id") Integer id){
        return null;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/user/{id}")
    public PaymentResponse getPaymentByUserId(@PathParam("id") Integer id){
        return null;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    public PaymentResponse save(PaymentRequest paymentRequest) {
        return null;
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, PaymentRequest paymentRequest) {
        return true;
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN } )
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return true;
    }
}
