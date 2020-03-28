package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

import java.io.Serializable;

public class RoleDTO implements Serializable{

    private Integer id;
    private String name;
    private Status status;

    public RoleDTO() {
    }

    public RoleDTO(Integer id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
