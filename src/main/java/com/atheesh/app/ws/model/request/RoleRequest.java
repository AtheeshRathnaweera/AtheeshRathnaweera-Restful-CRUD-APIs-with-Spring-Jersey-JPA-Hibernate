package com.atheesh.app.ws.model.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoleRequest {
    private String name;

    public RoleRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
