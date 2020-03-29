package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.Status;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemRequest {

    private String name;
    private String imageUrl;
    private Status status;

    public ItemRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                '}';
    }
}
