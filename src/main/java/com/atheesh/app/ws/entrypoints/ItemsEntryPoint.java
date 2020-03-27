package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.model.request.ItemRequest;
import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.ItemResponse;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.service.ItemService;
import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.atheesh.app.ws.factory.ConversionFactory.conversion;

@Component
@Path("items")
public class ItemsEntryPoint {

    @Autowired
    ItemService itemService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public List<ItemResponse> getItemsByStatus(Status status) {
        List<ItemDTO> itemDTOList = itemService.getItemByStatus(status);
        List<ItemResponse> itemResponseList = new ArrayList<>();

        for(ItemDTO itemDTO : itemDTOList){
            itemResponseList.add(convertDTOToResponse(itemDTO));
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
            itemResponseList.add(convertDTOToResponse(itemDTO));
        }
        return itemResponseList;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON } )
    @Produces({ MediaType.APPLICATION_JSON } )
    public ItemResponse save(ItemRequest itemRequest) {
        ItemDTO savedItem = itemService.save(convertRequestToDTO(itemRequest));
        return convertDTOToResponse(savedItem);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, ItemRequest newItemRequest) {
        return itemService.update(id,convertRequestToDTO(newItemRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN } )
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id) {
        return itemService.delete(id);
    }


    //conversion methods
    private ItemResponse convertDTOToResponse(ItemDTO itemDTO){
        return (ItemResponse) conversion(itemDTO,new ItemResponse());
    }

    private ItemDTO convertRequestToDTO(ItemRequest itemRequest){
        return (ItemDTO) conversion(itemRequest,new ItemRequest());
    }
}
