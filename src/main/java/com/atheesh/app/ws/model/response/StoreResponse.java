package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.Status;

public class StoreResponse {

    private Integer id;
    private ItemResponse item;
    private ShopResponse shop;
    private Integer amount;
    private Integer minLimit;
    private Integer unitQuantity;
    private String unitSymbol;
    private Float unitPrice;
    private String priceSymbol;
    private Status status;

    public StoreResponse() {
    }

    public StoreResponse(Integer id) {
        this.id = id;
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

    public Integer getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(Integer unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPriceSymbol() {
        return priceSymbol;
    }

    public void setPriceSymbol(String priceSymbol) {
        this.priceSymbol = priceSymbol;
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
                ", item=" + item +
                ", shop=" + shop +
                ", amount=" + amount +
                ", minLimit=" + minLimit +
                ", unitQuantity=" + unitQuantity +
                ", unitSymbol='" + unitSymbol + '\'' +
                ", unitPrice=" + unitPrice +
                ", priceSymbol='" + priceSymbol + '\'' +
                ", status=" + status +
                '}';
    }
}
