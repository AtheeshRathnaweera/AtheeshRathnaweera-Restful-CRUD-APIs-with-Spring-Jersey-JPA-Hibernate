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

    public static StoreDTO store(StoreEntity storeEntity){
        StoreDTO storeDTO = (StoreDTO) ConversionFactory.conversion(storeEntity,new StoreDTO());

        storeDTO.setItem(item(storeEntity.getItem()));
        storeDTO.setShop(shop(storeEntity.getShop()));

        return storeDTO;
    }

    public static OrderDTO order(OrderEntity orderEntity){
        OrderDTO orderDTO = (OrderDTO) ConversionFactory.conversion(orderEntity,new OrderDTO());

        if(orderEntity.getStore().getItem() != null || orderEntity.getStore().getShop() != null) {
            orderDTO.setStore(store(orderEntity.getStore()));
        }else{
            orderDTO.setStore(new StoreDTO(orderEntity.getStore().getId()));
        }

        orderDTO.setUser(user(orderEntity.getUser()));
        return orderDTO;

    }

    public static PaymentDTO payment(PaymentEntity paymentEntity){
        PaymentDTO paymentDTO = (PaymentDTO) ConversionFactory.conversion(paymentEntity,new PaymentDTO());

        if(paymentEntity.getOrder().getStore() != null){
            paymentDTO.setOrder(order(paymentEntity.getOrder()));
        }else{
            paymentDTO.setOrder(new OrderDTO(paymentEntity.getOrder().getId()));
        }

        return paymentDTO;
    }

}
