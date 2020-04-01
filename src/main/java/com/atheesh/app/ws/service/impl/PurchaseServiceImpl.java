package com.atheesh.app.ws.service.impl;


import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.service.*;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.PaymentDTO;
import com.atheesh.app.ws.shared.dto.PurchaseDTO;
import com.atheesh.app.ws.shared.dto.StoreDTO;
import com.atheesh.app.ws.shared.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("purchaseService")
@Transactional(propagation = Propagation.REQUIRED)
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    StoreService storeService;

    @Autowired
    OrderService orderService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    EmailService emailService;

    @Override
    public List<PurchaseDTO> purchase(PurchaseDTO purchaseDTO) {
        System.out.println("purchase methods started.");
        List<PurchaseDTO> purchaseDTOList = new ArrayList<>();

        for (OrderDTO orderDTO : purchaseDTO.getOrderList()) {
            List<OrderDTO> orderDTOList = new ArrayList<>();

            OrderDTO createdOrder = orderPlacement(orderDTO);

            System.out.println("created order = "+createdOrder.toString());

            if (createdOrder != null) {
                PurchaseDTO newPurchase = new PurchaseDTO();

                orderDTOList.add(createdOrder);

                purchaseDTO.getPayment().setOrder(createdOrder);
                PaymentDTO savedPayment = charging(purchaseDTO.getPayment());

                newPurchase.setOrderList(orderDTOList);
                newPurchase.setPayment(savedPayment);

                purchaseDTOList.add(newPurchase);
            }else{
                return null;
            }
        }

        return purchaseDTOList;
    }

    private OrderDTO orderPlacement(OrderDTO orderDTO) {
        StoreDTO storeDTO = storeService.getStoreById(orderDTO.getStore().getId());

        System.out.println("stored sto : " + storeDTO.toString());

        int itemsAmount = orderDTO.getAmount();
        float receivedPrice = orderDTO.getPrice();

        System.out.println("came here");

        float unitPrice = storeDTO.getUnitPrice();
        int unitQuantity = storeDTO.getUnitQuantity();

        float billPrice = unitPrice / unitQuantity * itemsAmount;

        if (receivedPrice == billPrice) {
            //charge the price

            orderDTO.setCreatedDate(new Date());
            orderDTO.setStatus(OrderStatus.PAID);

            return orderService.save(orderDTO);
        } else {
            System.out.println("wrong price");
            return null;
        }
    }

    private PaymentDTO charging(PaymentDTO paymentDTO) {
        paymentDTO.setPaymentDate(new Date());
        PaymentDTO paymentDTO1 =  paymentService.save(paymentDTO);
        System.out.println("email will be sent : "+paymentDTO1.toString());
        //emailService.sendMail("rathnaweeraatheesh72@gmail.com","Payment Confirmation","Hello test");
        //send the email
        return paymentDTO1;
    }
}
