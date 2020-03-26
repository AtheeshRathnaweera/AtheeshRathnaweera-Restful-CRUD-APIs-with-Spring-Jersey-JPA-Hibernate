package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.Status;

public class RoleRequest {

    private String name;
    private Status status;

    public RoleRequest() {
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
        return "RoleRequest{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
