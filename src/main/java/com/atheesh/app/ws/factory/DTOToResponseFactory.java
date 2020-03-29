package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.model.response.*;
import com.atheesh.app.ws.shared.dto.*;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class DTOToResponseFactory {

    public static CompanyResponse company(CompanyDTO companyDTO){
        return (CompanyResponse) conversion(companyDTO,new CompanyResponse());
    }

    public static ItemResponse item(ItemDTO itemDTO){
        return (ItemResponse) conversion(itemDTO,new ItemResponse());
    }

    public static RoleResponse role(RoleDTO roleDTO){
        return (RoleResponse) ConversionFactory.conversion(roleDTO,new RoleResponse());
    }

    public static UserRoleResponse userRole(UserRoleDTO userRoleDTO){

        UserResponse userResponse = new UserResponse(userRoleDTO.getUser().getId());
        RoleResponse roleResponse = new RoleResponse(userRoleDTO.getRole().getId());

        return new UserRoleResponse(userRoleDTO.getId(),userResponse,roleResponse);

    }

    public static UserResponse user(UserDTO userDTO){
        return (UserResponse) ConversionFactory.conversion(userDTO,new UserResponse());
    }

    public static ShopResponse shop(ShopDTO shopDTO){
        ShopResponse shopResponse = (ShopResponse) ConversionFactory.conversion(shopDTO,new ShopResponse());

        shopResponse.setCompany((CompanyResponse) ConversionFactory.conversion(shopDTO.getCompany(),new CompanyResponse()));
        shopResponse.setManager((UserResponse) ConversionFactory.conversion(shopDTO.getManager(),new UserResponse()));

        return shopResponse;
    }
}
