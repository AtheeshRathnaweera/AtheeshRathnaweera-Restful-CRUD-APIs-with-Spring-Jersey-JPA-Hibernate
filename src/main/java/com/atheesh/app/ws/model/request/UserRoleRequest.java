package com.atheesh.app.ws.model.request;


public class UserRoleRequest {

    private Integer userId;
    private String roleName;

    public UserRoleRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRoleRequest{" +
                "userId=" + userId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
