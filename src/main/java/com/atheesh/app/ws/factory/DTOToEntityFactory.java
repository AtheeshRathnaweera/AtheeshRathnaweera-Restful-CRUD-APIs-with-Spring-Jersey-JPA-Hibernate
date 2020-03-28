package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;

public class DTOToEntityFactory {

    public static UserEntity user(UserDTO userDTO){
        return (UserEntity) ConversionFactory.conversion(userDTO, new UserEntity());
    }

    public static RoleEntity role(RoleDTO roleDTO){
        return (RoleEntity) ConversionFactory.conversion(roleDTO,new RoleEntity());
    }
}
