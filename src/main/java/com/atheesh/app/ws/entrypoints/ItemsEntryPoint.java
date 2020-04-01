package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.ItemRequest;
import com.atheesh.app.ws.model.response.ItemResponse;
import com.atheesh.app.ws.service.ItemService;
import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("items")
public class ItemsEntryPoint {

    private final
    ItemService itemService;

    @Autowired
    public ItemsEntryPoint(ItemService itemService) {
        this.itemService = itemService;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/status/{status}")
    public List<ItemResponse> getItemsByStatus(@PathParam("status") Status status) {
        List<ItemDTO> itemDTOList = itemService.getItemByStatus(status);
        List<ItemResponse> itemResponseList = new ArrayList<>();

        for(ItemDTO itemDTO : itemDTOList){
            itemResponseList.add(DTOToResponseFactory.item(itemDTO));
        }
        return itemResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<ItemResponse> getAllItems() {
        List<ItemDTO> itemDTOList = itemService.getAllItems();
        List<ItemResponse> itemResponseList = new ArrayList<>();

        for(ItemDTO itemDTO : itemDTOList){
            itemResponseList.add(DTOToResponseFactory.item(itemDTO));
        }
        return itemResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public ItemResponse getItemById(@PathParam("id") Integer id){
        ItemDTO itemDTO = itemService.getItemById(id);
        return DTOToResponseFactory.item(itemDTO);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    public ItemResponse save(ItemRequest itemRequest) {
        ItemDTO savedItem = itemService.save(RequestToDTOFactory.item(itemRequest));
        return DTOToResponseFactory.item(savedItem);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, ItemRequest newItemRequest) {
        return itemService.update(id, RequestToDTOFactory.item(newItemRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN } )
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return itemService.delete(id);
    }


}
