package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.Status;

public class ShopResponse {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String district;
    private String town;
    private String address;
    private CompanyResponse company;
    private UserResponse manager;
    private Status status;

    public ShopResponse() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CompanyResponse getCompany() {
        return company;
    }

    public void setCompany(CompanyResponse company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserResponse getManager() {
        return manager;
    }

    public void setManager(UserResponse manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "ShopResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", district='" + district + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company.toString() +
                ", manager=" + manager.toString() +
                ", status=" + status +
                '}';
    }
}
