package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.CompanyEntity;
import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.shared.dto.CompanyDTO;
import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;

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
}
