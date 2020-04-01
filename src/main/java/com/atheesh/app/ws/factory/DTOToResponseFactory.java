package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.model.response.*;
import com.atheesh.app.ws.repositories.PaymentRepository;
import com.atheesh.app.ws.shared.dto.*;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class DTOToResponseFactory {

    public static CompanyResponse company(CompanyDTO companyDTO) {
        return (CompanyResponse) conversion(companyDTO, new CompanyResponse());
    }

    public static ItemResponse item(ItemDTO itemDTO) {
        return (ItemResponse) conversion(itemDTO, new ItemResponse());
    }

    public static RoleResponse role(RoleDTO roleDTO) {
        return (RoleResponse) ConversionFactory.conversion(roleDTO, new RoleResponse());
    }

    public static UserRoleResponse userRole(UserRoleDTO userRoleDTO) {

        UserRoleResponse userRoleResponse = (UserRoleResponse) ConversionFactory.conversion(userRoleDTO, new UserRoleResponse());

        userRoleResponse.setRole(role(userRoleDTO.getRole()));
        userRoleResponse.setUser(user(userRoleDTO.getUser()));

        return userRoleResponse;

    }

    public static UserResponse user(UserDTO userDTO) {
        return (UserResponse) ConversionFactory.conversion(userDTO, new UserResponse());
    }

    public static ShopResponse shop(ShopDTO shopDTO) {
        ShopResponse shopResponse = (ShopResponse) ConversionFactory.conversion(shopDTO, new ShopResponse());

        shopResponse.setCompany(company(shopDTO.getCompany()));
        shopResponse.setManager(user(shopDTO.getManager()));

        return shopResponse;
    }

    public static StoreResponse store(StoreDTO storeDTO) {
        StoreResponse storeResponse = (StoreResponse) ConversionFactory.conversion(storeDTO, new StoreResponse());

        storeResponse.setItem(item(storeDTO.getItem()));
        storeResponse.setShop(shop(storeDTO.getShop()));

        return storeResponse;
    }

    public static OrderResponse order(OrderDTO orderDTO) {
        OrderResponse orderResponse = (OrderResponse) ConversionFactory.conversion(orderDTO, new OrderResponse());

        if (orderDTO.getStore().getItem() != null || orderDTO.getStore().getShop() != null) {
            orderResponse.setStore(store(orderDTO.getStore()));
        } else {
            orderResponse.setStore(new StoreResponse(orderDTO.getStore().getId()));
        }

        orderResponse.setUser(user(orderDTO.getUser()));
        return orderResponse;
    }

    public static PaymentResponse payment(PaymentDTO paymentDTO) {
        PaymentResponse paymentResponse = (PaymentResponse) ConversionFactory.conversion(paymentDTO, new PaymentResponse());

        if (paymentDTO.getOrder().getStore() != null) {
            paymentResponse.setOrder(order(paymentDTO.getOrder()));
        } else {
            paymentResponse.setOrder(new OrderResponse(paymentDTO.getOrder().getId()));
        }
        return paymentResponse;
    }
}
