package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.model.request.RoleRequest;
import com.atheesh.app.ws.model.response.RoleResponse;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import org.springframework.beans.BeanUtils;

public class RoleFactory {

    public static RoleDTO convertRequestToDTO(RoleRequest roleRequest){
        if(roleRequest != null) {
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(roleRequest, roleDTO);
            return roleDTO;
        }else {
            return null;
        }
    }

    public static RoleEntity convertDTOToEntity(RoleDTO roleDTO){
        if(roleDTO != null) {
            RoleEntity roleEntity = new RoleEntity();
            BeanUtils.copyProperties(roleDTO, roleEntity);
            return roleEntity;
        }else{
            return null;
        }
    }

    public static RoleDTO convertEntityToDTO(RoleEntity roleEntity){
        if(roleEntity != null) {
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(roleEntity, roleDTO);
            return roleDTO;
        }else{
            return null;
        }
    }

    public static RoleResponse convertDTOTOResponse(RoleDTO roleDTO){
        if(roleDTO != null) {
            RoleResponse roleResponse = new RoleResponse();
            BeanUtils.copyProperties(roleDTO, roleResponse);
            return roleResponse;
        }else{
            return null;
        }
    }

}
