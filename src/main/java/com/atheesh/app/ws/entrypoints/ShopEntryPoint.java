package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.ShopRequest;
import com.atheesh.app.ws.model.response.ShopResponse;
import com.atheesh.app.ws.service.ShopService;
import com.atheesh.app.ws.shared.dto.ShopDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("shop")
public class ShopEntryPoint {

    private final
    ShopService shopService;

    @Autowired
    public ShopEntryPoint(ShopService shopService) {
        this.shopService = shopService;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public ShopResponse getShopById(@PathParam("id") Integer id) {
        ShopDTO shopDTO = shopService.getShopById(id);
        return DTOToResponseFactory.shop(shopDTO);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/manager/{id}")
    public List<ShopResponse> getShopByManagerId(@PathParam("id") Integer id) {
        List<ShopDTO> shopDTOList = shopService.getShopsByManager(id);
        List<ShopResponse> shopResponseList = new ArrayList<>();

        for (ShopDTO shopDTO : shopDTOList) {
            shopResponseList.add(DTOToResponseFactory.shop(shopDTO));
        }
        return shopResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/status/{status}")
    public List<ShopResponse> getAllActiveShops(@PathParam("status") Status status) {
        List<ShopDTO> shopDTOList = shopService.getShopsByStatus(status);
        List<ShopResponse> shopResponseList = new ArrayList<>();

        for (ShopDTO shopDTO : shopDTOList) {
            shopResponseList.add(DTOToResponseFactory.shop(shopDTO));
        }
        return shopResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/all")
    public List<ShopResponse> getAllShops() {
        List<ShopDTO> shopDTOList = shopService.getAllShops();
        List<ShopResponse> shopResponseList = new ArrayList<>();

        for (ShopDTO shopDTO : shopDTOList) {
            shopResponseList.add(DTOToResponseFactory.shop(shopDTO));
        }
        return shopResponseList;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_JSON})
    public ShopResponse save(ShopRequest shopRequest) {
        ShopDTO shopDTO = shopService.save(RequestToDTOFactory.shop(shopRequest));
        return DTOToResponseFactory.shop(shopDTO);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, ShopRequest shopRequest) {
        return shopService.update(id,RequestToDTOFactory.shop(shopRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return shopService.delete(id);
    }

}
