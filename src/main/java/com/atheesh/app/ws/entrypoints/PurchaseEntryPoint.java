package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.PurchaseRequest;
import com.atheesh.app.ws.model.response.PaymentResponse;
import com.atheesh.app.ws.service.EmailService;
import com.atheesh.app.ws.service.PurchaseService;
import com.atheesh.app.ws.shared.dto.*;
import com.atheesh.app.ws.shared.enums.CardType;
import com.atheesh.app.ws.shared.enums.PaymentMethod;
import com.atheesh.app.ws.shared.enums.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Path("purchase")
public class PurchaseEntryPoint {

    private final
    PurchaseService purchaseService;

    @Autowired
    EmailService emailService;

    @Autowired
    public PurchaseEntryPoint(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<PaymentResponse> save(PurchaseRequest purchaseRequest) {
        List<PurchaseDTO> purchaseDTOList = purchaseService.purchase(RequestToDTOFactory.purchase(purchaseRequest));
        List<PaymentResponse> paymentResponseList = new ArrayList<>();

        for(PurchaseDTO purchaseDTO : purchaseDTOList){
            paymentResponseList.add(DTOToResponseFactory.payment(purchaseDTO.getPayment()));
        }

        return paymentResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public void save() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(34);
        paymentDTO.setMethod(PaymentMethod.CARD);
        paymentDTO.setCardNo("9876567");
        paymentDTO.setCardType(CardType.DEBIT);
        paymentDTO.setPaymentDate(new Date());

        OrderDTO orderDTO = new OrderDTO();
        UserDTO userDTO = new UserDTO();
        StoreDTO storeDTO = new StoreDTO();
        ShopDTO shopDTO = new ShopDTO();
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setName("PUMA 456 Running Shoe");

        shopDTO.setName("Puma Sri Lanka");
        shopDTO.setEmail("pumasl@gmail.com");
        shopDTO.setPhoneNumber("0723472312");

        storeDTO.setShop(shopDTO);
        storeDTO.setItem(itemDTO);

        userDTO.setEmail("danushiatheesh123@gmail.com");
        userDTO.setFirstName("Dhanushi");
        userDTO.setLastName("Karunarathne");
        userDTO.setId(3456);

        orderDTO.setId(654);
        orderDTO.setAmount(2);
        orderDTO.setPrice(340.00f);
        orderDTO.setUser(userDTO);
        orderDTO.setStore(storeDTO);

        paymentDTO.setOrder(orderDTO);


        emailService.sendOrderConfirmationMail("danushiatheesh123@gmail.com","ORDER CONFIRMED",paymentDTO);
    }

}
