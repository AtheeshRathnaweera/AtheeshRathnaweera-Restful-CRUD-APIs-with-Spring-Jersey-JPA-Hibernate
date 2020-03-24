package com.atheesh.app.ws.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;
}
