package com.atheesh.app.ws.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemEntity item;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private ShopEntity shop;

    @NotNull
    private Integer amount;

    @NotNull
    private Integer minLimit;





}
