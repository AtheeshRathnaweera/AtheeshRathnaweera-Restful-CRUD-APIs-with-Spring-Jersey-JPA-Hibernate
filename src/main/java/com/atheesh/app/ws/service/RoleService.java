package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO getRoleById(int id);
    List<RoleDTO> getAllRoles();
    RoleDTO save(RoleDTO roleDTO);
    boolean update(int id, RoleDTO roleDTO);
    boolean delete(int id);
}
