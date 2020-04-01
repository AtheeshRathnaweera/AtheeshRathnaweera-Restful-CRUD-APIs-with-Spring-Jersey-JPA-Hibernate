package com.atheesh.app.ws.model.response;

import java.util.List;

public class PurchaseResponse {

    private List<OrderResponse> orderList;
    private PaymentResponse payment;

    public PurchaseResponse() {
    }

    public List<OrderResponse> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderResponse> orderList) {
        this.orderList = orderList;
    }

    public PaymentResponse getPayment() {
        return payment;
    }

    public void setPayment(PaymentResponse payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                ", orderList=" + orderList +
                ", payment=" + payment +
                '}';
    }
}
