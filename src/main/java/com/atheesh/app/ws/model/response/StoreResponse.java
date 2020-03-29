package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.Status;

public class StoreResponse {

    private Integer id;
    private ItemResponse item;
    private ShopResponse shop;
    private Integer amount;
    private Integer minLimit;
    private Status status;

    public StoreResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }

    public ShopResponse getShop() {
        return shop;
    }

    public void setShop(ShopResponse shop) {
        this.shop = shop;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StoreResponse{" +
                "id=" + id +
                ", item=" + item.toString() +
                ", shop=" + shop.toString() +
                ", amount=" + amount +
                ", minLimit=" + minLimit +
                ", status=" + status +
                '}';
    }
}
