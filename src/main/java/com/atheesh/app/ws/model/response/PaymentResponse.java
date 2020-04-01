package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.CardType;
import com.atheesh.app.ws.shared.enums.PaymentMethod;
import com.atheesh.app.ws.shared.enums.PaymentStatus;

import java.util.Date;

public class PaymentResponse {

    private Integer id;
    private OrderResponse order;
    private PaymentMethod method;
    private CardType cardType;
    private String cardNo;
    private PaymentStatus status;
    private Date paymentDate;

    public PaymentResponse() {
    }

    public PaymentResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderResponse getOrder() {
        return order;
    }

    public void setOrder(OrderResponse order) {
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "id=" + id +
                ", order=" + order +
                ", method=" + method +
                ", cardType=" + cardType +
                ", cardNo='" + cardNo + '\'' +
                ", status=" + status +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
