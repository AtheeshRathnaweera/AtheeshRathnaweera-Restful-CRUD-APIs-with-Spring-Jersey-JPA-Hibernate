package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.model.request.*;
import com.atheesh.app.ws.model.response.OrderResponse;
import com.atheesh.app.ws.shared.dto.*;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

public class RequestToDTOFactory {

    public static CompanyDTO company(CompanyRequest companyRequest){
        return (CompanyDTO) conversion(companyRequest, new CompanyDTO());
    }

    public static ItemDTO item(ItemRequest itemRequest){
        return (ItemDTO) conversion(itemRequest,new ItemDTO());
    }

    public static RoleDTO role(RoleRequest roleRequest){
        return (RoleDTO) ConversionFactory.conversion(roleRequest,new RoleDTO());
    }

    public static UserRoleDTO userRole(UserRoleRequest userRoleRequest){

        UserDTO newUser = new UserDTO(userRoleRequest.getUserId());
        RoleDTO newRole = new RoleDTO();
        newRole.setName(userRoleRequest.getRoleName());

        return new UserRoleDTO(null,newUser,newRole);

    }

    public static UserDTO user(UserRequest userRequest){
        return (UserDTO) ConversionFactory.conversion(userRequest,new UserDTO());
    }

    public static ShopDTO shop(ShopRequest shopRequest){
        CompanyDTO companyDTO = new CompanyDTO(shopRequest.getCompanyId());
        UserDTO userDTO = new UserDTO(shopRequest.getManagerId());

        return new ShopDTO(null,shopRequest.getName(),shopRequest.getEmail(),shopRequest.getPhoneNumber(),
                shopRequest.getDistrict(),shopRequest.getTown(),shopRequest.getAddress(),companyDTO,userDTO,shopRequest.getStatus());

    }

    public static StoreDTO store(StoreRequest storeRequest){
        ShopDTO shopDTO = new ShopDTO(storeRequest.getShopId());
        ItemDTO itemDTO = new ItemDTO(storeRequest.getItemId());

        return new StoreDTO(null,itemDTO,shopDTO,storeRequest.getAmount(),storeRequest.getMinLimit(),storeRequest.getUnitQuantity(),
                storeRequest.getUnitSymbol(),storeRequest.getUnitPrice(),storeRequest.getPriceSymbol()
                ,storeRequest.getStatus());
    }


    public static OrderDTO order(OrderRequest orderRequest){
        StoreDTO storeDTO = new StoreDTO(orderRequest.getStoreId());
        UserDTO userDTO = new UserDTO(orderRequest.getUserId());

        OrderDTO orderDTO = (OrderDTO) ConversionFactory.conversion(orderRequest, new OrderDTO());
        orderDTO.setStore(storeDTO);
        orderDTO.setUser(userDTO);

        return orderDTO;
    }

    public static PaymentDTO payment(PaymentRequest paymentRequest){
        PaymentDTO paymentDTO = (PaymentDTO) ConversionFactory.conversion(paymentRequest,new PaymentDTO());

        OrderDTO orderDTO = new OrderDTO(paymentRequest.getOrderId());
        paymentDTO.setOrder(orderDTO);

        return paymentDTO;

    }
}
