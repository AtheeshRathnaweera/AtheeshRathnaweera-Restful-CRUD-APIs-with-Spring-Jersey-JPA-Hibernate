package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

public class StoreDTO {

    private Integer id;
    private ItemDTO item;
    private ShopDTO shop;
    private Integer amount;
    private Integer minLimit;
    private Integer currentPrice;
    private Status status;

    public StoreDTO() {
    }

    public StoreDTO(Integer id, ItemDTO item, ShopDTO shop, Integer amount, Integer minLimit, Integer currentPrice, Status status) {
        this.id = id;
        this.item = item;
        this.shop = shop;
        this.amount = amount;
        this.minLimit = minLimit;
        this.currentPrice = currentPrice;
        this.status = status;
    }

    public StoreDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
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

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id=" + id +
                ", item=" + item +
                ", shop=" + shop +
                ", amount=" + amount +
                ", minLimit=" + minLimit +
                ", currentPrice=" + currentPrice +
                ", status=" + status +
                '}';
    }
}
