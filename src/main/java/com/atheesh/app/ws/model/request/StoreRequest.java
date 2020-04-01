package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.Status;

public class StoreRequest {

    private Integer itemId;
    private Integer shopId;
    private Integer amount;
    private Integer minLimit;
    private Integer unitQuantity;
    private String unitSymbol;
    private Float unitPrice;
    private String priceSymbol;
    private Status status;

    public StoreRequest() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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
        return "StoreRequest{" +
                "itemId=" + itemId +
                ", shopId=" + shopId +
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
