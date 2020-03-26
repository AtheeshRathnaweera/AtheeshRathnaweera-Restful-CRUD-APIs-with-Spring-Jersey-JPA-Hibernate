package com.atheesh.app.ws.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoleResponse {

    private int id;
    private String name;

    public RoleResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
