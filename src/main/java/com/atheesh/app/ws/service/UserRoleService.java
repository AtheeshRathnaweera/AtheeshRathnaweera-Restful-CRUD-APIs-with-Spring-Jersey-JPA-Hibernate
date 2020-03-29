package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.UserRoleDTO;

import java.util.List;

public interface UserRoleService {

    List<UserRoleDTO> getAllUserRoles();
    List<UserRoleDTO> getUserRolesByUser(Integer userId);
    List<UserRoleDTO> getUserRolesByRole(String roleName);
    UserRoleDTO getUserRoleById(Integer id);
    UserRoleDTO save(UserRoleDTO userRoleDTO);
    boolean update(Integer id, UserRoleDTO userRoleDTO);
    boolean delete(Integer id);
}
