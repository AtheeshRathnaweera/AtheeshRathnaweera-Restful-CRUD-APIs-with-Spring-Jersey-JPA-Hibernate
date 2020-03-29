package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.*;
import com.atheesh.app.ws.shared.dto.*;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class EntityToDTOFactory {

    public static UserDTO user(UserEntity userEntity){
        return (UserDTO) ConversionFactory.conversion(userEntity,new UserDTO());
    }

    public static UserRoleDTO userRole(UserRoleEntity userRoleEntity){
        UserRoleDTO userRoleDTO = (UserRoleDTO) ConversionFactory.conversion(userRoleEntity,new UserRoleDTO());

        userRoleDTO.setUser(user(userRoleEntity.getUser()));
        userRoleDTO.setRole(role(userRoleEntity.getRole()));

        return userRoleDTO;

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

    public static ShopDTO shop(ShopEntity shopEntity){
        ShopDTO shopDTO = (ShopDTO) ConversionFactory.conversion(shopEntity,new ShopDTO());

        shopDTO.setCompany(company(shopEntity.getCompany()));
        shopDTO.setManager(user(shopEntity.getManager()));

        return shopDTO;
    }


}
