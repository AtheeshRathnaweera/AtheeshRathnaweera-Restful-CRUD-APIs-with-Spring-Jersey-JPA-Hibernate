package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.entities.OrderEntity;
import com.atheesh.app.ws.shared.enums.CardType;
import com.atheesh.app.ws.shared.enums.PaymentMethod;
import com.atheesh.app.ws.shared.enums.PaymentStatus;

public class PaymentRequest {

    private OrderEntity order;
    private PaymentMethod method;
    private CardType cardType;
    private String cardNo;
    private PaymentStatus status;

    public PaymentRequest() {
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "order=" + order +
                ", method=" + method +
                ", cardType=" + cardType +
                ", cardNo='" + cardNo + '\'' +
                ", status=" + status +
                '}';
    }
}
