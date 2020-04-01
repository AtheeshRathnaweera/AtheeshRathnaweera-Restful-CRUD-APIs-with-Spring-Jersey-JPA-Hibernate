package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

public class StoreDTO {

    private Integer id;
    private ItemDTO item;
    private ShopDTO shop;
    private Integer amount;
    private Integer minLimit;
    private Integer unitQuantity;
    private String unitSymbol;
    private Integer unitPrice;
    private String priceSymbol;
    private Status status;

    public StoreDTO() {
    }

    public StoreDTO(Integer id, ItemDTO item, ShopDTO shop, Integer amount, Integer minLimit, Integer unitQuantity, String unitSymbol, Integer unitPrice, String priceSymbol, Status status) {
        this.id = id;
        this.item = item;
        this.shop = shop;
        this.amount = amount;
        this.minLimit = minLimit;
        this.unitQuantity = unitQuantity;
        this.unitSymbol = unitSymbol;
        this.unitPrice = unitPrice;
        this.priceSymbol = priceSymbol;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPriceSymbol() {
        return priceSymbol;
    }

    public void setPriceSymbol(String priceSymbol) {
        this.priceSymbol = priceSymbol;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id=" + id +
                ", item=" + item +
                ", shop=" + shop +
                ", amount=" + amount +
                ", minLimit=" + minLimit +
                ", unitQuantity=" + unitQuantity +
                ", unitSymbol=" + unitSymbol +
                ", unitPrice=" + unitPrice +
                ", priceSymbol='" + priceSymbol + '\'' +
                ", status=" + status +
                '}';
    }
}
