package com.atheesh.app.ws.model.request;

public class PurchaseRequest {

    private OrderRequest orderRequest;
    private PaymentRequest paymentRequest;

    public PurchaseRequest() {
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }
}
