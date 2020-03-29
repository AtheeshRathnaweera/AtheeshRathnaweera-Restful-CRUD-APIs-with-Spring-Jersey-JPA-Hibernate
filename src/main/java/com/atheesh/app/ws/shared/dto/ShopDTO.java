package com.atheesh.app.ws.shared.dto;

import com.atheesh.app.ws.shared.enums.Status;

public class ShopDTO {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String district;
    private String town;
    private String address;
    private CompanyDTO company;
    private UserDTO manager;
    private Status status;

    public ShopDTO() {
    }

    public ShopDTO(Integer id) {
        this.id = id;
    }

    public ShopDTO(Integer id, String name, String email, String phoneNumber, String district, String town, String address, CompanyDTO company, UserDTO manager, Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.town = town;
        this.address = address;
        this.company = company;
        this.manager = manager;
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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public UserDTO getManager() {
        return manager;
    }

    public void setManager(UserDTO manager) {
        this.manager = manager;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", district='" + district + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                ", manager=" + manager +
                ", status=" + status +
                '}';
    }
}
