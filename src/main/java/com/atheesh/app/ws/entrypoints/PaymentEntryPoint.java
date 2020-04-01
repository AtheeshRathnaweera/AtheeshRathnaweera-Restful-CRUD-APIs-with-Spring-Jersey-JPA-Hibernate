package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.PaymentRequest;
import com.atheesh.app.ws.model.response.PaymentResponse;
import com.atheesh.app.ws.service.PaymentService;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.PaymentDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("payment")
public class PaymentEntryPoint {

    @Autowired
    PaymentService paymentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/all")
    public List<PaymentResponse> getAllPayments() {
        List<PaymentDTO> paymentDTOList = paymentService.getAllPayments();
        List<PaymentResponse> paymentResponseList = new ArrayList<>();

        for (PaymentDTO paymentDTO : paymentDTOList) {
            paymentResponseList.add(DTOToResponseFactory.payment(paymentDTO));
        }
        return paymentResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public PaymentResponse getPaymentById(@PathParam("id") Integer id) {
        PaymentDTO paymentDTO = paymentService.getPaymentById(id);
        return DTOToResponseFactory.payment(paymentDTO);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/order/{id}")
    public PaymentResponse getPaymentByOrderId(@PathParam("id") Integer id) {
        PaymentDTO paymentDTO = paymentService.getPaymentByOrder(id);
        return DTOToResponseFactory.payment(paymentDTO);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/user/{id}")
    public List<PaymentResponse> getPaymentsByUserId(@PathParam("id") Integer id) {
        List<PaymentDTO> paymentDTOList = paymentService.getPaymentsByUser(new UserDTO(id));
        List<PaymentResponse> paymentResponseList = new ArrayList<>();

        for(PaymentDTO paymentDTO : paymentDTOList){
           paymentResponseList.add(DTOToResponseFactory.payment(paymentDTO));
        }
        return paymentResponseList;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public PaymentResponse save(PaymentRequest paymentRequest) {
        PaymentDTO paymentDTO = paymentService.save(RequestToDTOFactory.payment(paymentRequest));
        return DTOToResponseFactory.payment(paymentDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, PaymentRequest paymentRequest) {
        return true;
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return paymentService.delete(id);
    }
}
