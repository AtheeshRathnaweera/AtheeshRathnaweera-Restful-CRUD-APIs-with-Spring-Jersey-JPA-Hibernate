package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.*;
import com.atheesh.app.ws.shared.dto.*;

import javax.jws.soap.SOAPBinding;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class DTOToEntityFactory {

    public static UserEntity user(UserDTO userDTO){
        return (UserEntity) ConversionFactory.conversion(userDTO, new UserEntity());
    }

    public static RoleEntity role(RoleDTO roleDTO){
        return (RoleEntity) ConversionFactory.conversion(roleDTO,new RoleEntity());
    }

    public static CompanyEntity company(CompanyDTO companyDTO){
        return (CompanyEntity) conversion(companyDTO,new CompanyEntity());
    }

    public static ItemEntity item(ItemDTO itemDTO){
        return (ItemEntity) ConversionFactory.conversion(itemDTO,new ItemEntity());
    }

    public static UserRoleEntity userRole(UserRoleDTO userRoleDTO){
        UserRoleEntity userRoleEntity = (UserRoleEntity) ConversionFactory.conversion(userRoleDTO, new UserRoleEntity());

        userRoleEntity.setUser(user(userRoleDTO.getUser()));
        userRoleEntity.setRole(role(userRoleDTO.getRole()));

        return userRoleEntity;
    }

    public static ShopEntity shop(ShopDTO shopDTO){
        ShopEntity convertedShop =  (ShopEntity) ConversionFactory.conversion(shopDTO,new ShopEntity());

        convertedShop.setCompany(company(shopDTO.getCompany()));
        convertedShop.setManager(user(shopDTO.getManager()));

        return convertedShop;
    }
}
