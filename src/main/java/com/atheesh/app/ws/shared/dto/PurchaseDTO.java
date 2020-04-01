package com.atheesh.app.ws.shared.dto;

import java.util.List;

public class PurchaseDTO {

    private List<OrderDTO> orderList;
    private PaymentDTO payment;

    public PurchaseDTO() {
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                ", orderList=" + orderList +
                ", payment=" + payment +
                '}';
    }
}
