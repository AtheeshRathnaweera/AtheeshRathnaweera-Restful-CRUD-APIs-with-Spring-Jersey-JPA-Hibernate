package com.atheesh.app.ws.model.response;


public class UserRoleResponse {

    private Integer id;
    private UserResponse user;
    private RoleResponse role;

    public UserRoleResponse() {
    }

    public UserRoleResponse(Integer id, UserResponse user, RoleResponse role) {
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

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleResponse{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
