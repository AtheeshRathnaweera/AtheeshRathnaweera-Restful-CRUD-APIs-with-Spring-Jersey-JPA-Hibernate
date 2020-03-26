package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

import java.io.Serializable;
import java.util.Date;

public class ItemDTO implements Serializable {

    private Integer id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private Status status;

    public ItemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", status=" + status +
                '}';
    }
}
