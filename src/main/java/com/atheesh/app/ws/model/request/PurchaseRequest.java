package com.atheesh.app.ws.model.request;

import java.util.List;

public class PurchaseRequest {

    private List<OrderRequest> orderList;
    private PaymentRequest payment;

    public PurchaseRequest() {
    }

    public List<OrderRequest> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderRequest> orderList) {
        this.orderList = orderList;
    }

    public PaymentRequest getPayment() {
        return payment;
    }

    public void setPayment(PaymentRequest payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "orderList=" + orderList +
                ", payment=" + payment +
                '}';
    }
}
