package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

public class CompanyDTO {

    private Integer id;
    private String name;
    private String websiteUrl;
    private String phoneNumber;
    private Status status;

    public CompanyDTO() {
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
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
