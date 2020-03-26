package com.atheesh.app.ws.entities;

import com.atheesh.app.ws.shared.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String websiteUrl;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Status status;

    public CompanyEntity() {
    }

    public CompanyEntity(@NotNull String name, @NotNull String websiteUrl, @NotNull String phoneNumber, @NotNull Status status) {
        this.name = name;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        this.status = status;
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
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
