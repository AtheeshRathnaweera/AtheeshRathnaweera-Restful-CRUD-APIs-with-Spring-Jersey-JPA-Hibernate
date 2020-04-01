package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.OrderStatus;

import java.util.Date;

public class OrderResponse {

    private Integer id;
    private StoreResponse store;
    private UserResponse user;
    private Integer amount;
    private Integer price;
    private OrderStatus status;
    private Date createdDate;
    private Date updatedDate;

    public OrderResponse() {
    }

    public OrderResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StoreResponse getStore() {
        return store;
    }

    public void setStore(StoreResponse store) {
        this.store = store;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "id=" + id +
                ", store=" + store +
                ", user=" + user +
                ", amount=" + amount +
                ", price=" + price +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
