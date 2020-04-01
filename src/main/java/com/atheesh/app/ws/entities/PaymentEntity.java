package com.atheesh.app.ws.entities;

import com.atheesh.app.ws.shared.enums.CardType;
import com.atheesh.app.ws.shared.enums.PaymentMethod;
import com.atheesh.app.ws.shared.enums.PaymentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderEntity order;

    @NotNull
    private PaymentMethod method;

    private CardType cardType;

    private String cardNo;

    @NotNull
    private PaymentStatus status;

    @NotNull
    private Date paymentDate;

    public PaymentEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
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
