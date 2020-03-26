package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.Status;

public class CompanyRequest {

    private String name;
    private String websiteUrl;
    private String phoneNumber;
    private Status status;

    public CompanyRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CompanyRequest{" +
                "name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
