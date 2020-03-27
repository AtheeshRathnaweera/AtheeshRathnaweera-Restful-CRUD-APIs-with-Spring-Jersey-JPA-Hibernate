package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.enums.Status;

import java.util.List;

public interface RoleService {

    RoleDTO getRoleById(Integer id);
    List<RoleDTO> getAllRoles();
    List<RoleDTO> getRolesByStatus(Status status);
    RoleDTO save(RoleDTO roleDTO);
    boolean update(Integer id, RoleDTO roleDTO);
    boolean delete(Integer id);
}
