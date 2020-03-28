package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.*;
import com.atheesh.app.ws.shared.dto.*;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class EntityToDTOFactory {

    public static UserDTO user(UserEntity userEntity){
        return (UserDTO) ConversionFactory.conversion(userEntity,new UserDTO());
    }

    public static UserRoleDTO userRole(UserRoleEntity userRoleEntity){
        RoleDTO newRoleDTO = new RoleDTO(userRoleEntity.getRole().getId());
        UserDTO newUserDTO = new UserDTO(userRoleEntity.getUser().getId());

        return new UserRoleDTO(userRoleEntity.getId(),newUserDTO,newRoleDTO);

    }

    public static CompanyDTO company(CompanyEntity companyEntity){
        return (CompanyDTO) conversion(companyEntity, new CompanyDTO());
    }

    public static ItemDTO item(ItemEntity itemEntity){
        return (ItemDTO) ConversionFactory.conversion(itemEntity,new ItemDTO());
    }

    public static RoleDTO role(RoleEntity roleEntity){
        return (RoleDTO) ConversionFactory.conversion(roleEntity,new RoleDTO());
    }

}
