package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.entities.UserRoleEntity;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.dto.UserRoleDTO;

public class EntityToDTOFactory {

    public static UserDTO user(UserEntity userEntity){
        return (UserDTO) ConversionFactory.conversion(userEntity,new UserDTO());
    }

    public static UserRoleDTO userRole(UserRoleEntity userRoleEntity){
        RoleDTO newRoleDTO = new RoleDTO(userRoleEntity.getRole().getId());
        UserDTO newUserDTO = new UserDTO(userRoleEntity.getUser().getId());

        return new UserRoleDTO(userRoleEntity.getId(),newUserDTO,newRoleDTO);

    }

}
