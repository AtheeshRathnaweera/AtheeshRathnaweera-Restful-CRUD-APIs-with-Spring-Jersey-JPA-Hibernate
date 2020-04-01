package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.StoreRequest;
import com.atheesh.app.ws.model.response.StoreResponse;
import com.atheesh.app.ws.service.StoreService;
import com.atheesh.app.ws.shared.dto.StoreDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("store")
public class StoreEntryPoint {

    private final
    StoreService storeService;

    @Autowired
    public StoreEntryPoint(StoreService storeService) {
        this.storeService = storeService;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public StoreResponse getStoreById(@PathParam("id") Integer id) {
        StoreDTO storeDTO = storeService.getStoreById(id);
        return DTOToResponseFactory.store(storeDTO);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/all")
    public List<StoreResponse> getAllStore() {
       List<StoreDTO> storeDTOList = storeService.getAllStores();
       List<StoreResponse> storeResponseList = new ArrayList<>();

       for(StoreDTO storeDTO : storeDTOList){
           storeResponseList.add(DTOToResponseFactory.store(storeDTO));
       }
       return storeResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/status/{status}")
    public List<StoreResponse> getStoresByStatus(@PathParam("status") Status status) {
        List<StoreDTO> storeDTOList = storeService.getStoresByStatus(status);
        List<StoreResponse> storeResponseList = new ArrayList<>();

        for(StoreDTO storeDTO : storeDTOList){
            storeResponseList.add(DTOToResponseFactory.store(storeDTO));
        }
        return storeResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/shop/{shopId}")
    public List<StoreResponse> getStoresByShop(@PathParam("shopId") Integer shopId) {
        List<StoreDTO> storeDTOList = storeService.getStoresByShop(shopId);
        List<StoreResponse> storeResponseList = new ArrayList<>();

        for(StoreDTO storeDTO : storeDTOList){
            storeResponseList.add(DTOToResponseFactory.store(storeDTO));
        }
        return storeResponseList;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/item/{itemId}")
    public List<StoreResponse> getStoresByItem(@PathParam("itemId") Integer itemId) {
        List<StoreDTO> storeDTOList =storeService.getStoresByItem(itemId);
        List<StoreResponse> storeResponseList = new ArrayList<>();

        for(StoreDTO storeDTO : storeDTOList){
            storeResponseList.add(DTOToResponseFactory.store(storeDTO));
        }
        return storeResponseList;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_JSON})
    public StoreResponse save(StoreRequest storeRequest){
        StoreDTO savedDTO = storeService.save(RequestToDTOFactory.store(storeRequest));
        return DTOToResponseFactory.store(savedDTO);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, StoreRequest storeRequest){
        return storeService.update(id,RequestToDTOFactory.store(storeRequest));
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id){
        return storeService.delete(id);
    }

}
