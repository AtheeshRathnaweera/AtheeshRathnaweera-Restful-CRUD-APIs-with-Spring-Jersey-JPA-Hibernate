package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.OrderStatus;

public class OrderRequest {

    private Integer storeId;
    private Integer userId;
    private Integer amount;
    private Float price;
    private OrderStatus status;

    public OrderRequest() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                ", storeId=" + storeId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
