package com.atheesh.app.ws.entrypoints;

import com.atheesh.app.ws.model.request.SaveUserRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("items")
public class ItemsEntryPoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllItems() {
        return "All items will be received.";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String save(SaveUserRequest saveUserRequest) {
        return "item will be saved";
    }
}
