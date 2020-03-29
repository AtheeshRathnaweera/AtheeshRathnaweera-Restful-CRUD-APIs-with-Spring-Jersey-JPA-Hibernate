package com.atheesh.app.ws.shared.dto;

public class UserRoleDTO {

    private Integer id;
    private UserDTO user;
    private RoleDTO role;

    public UserRoleDTO() {
    }

    public UserRoleDTO(Integer id, UserDTO user, RoleDTO role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
