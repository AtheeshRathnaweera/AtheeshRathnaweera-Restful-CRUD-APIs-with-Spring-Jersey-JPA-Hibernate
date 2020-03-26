package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.Status;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoleResponse {

    private Integer id;
    private String name;
    private Status status;

    public RoleResponse() {
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
        return "RoleResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
