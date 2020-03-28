package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.RequestToDTOFactory;
import com.atheesh.app.ws.model.request.RoleRequest;
import com.atheesh.app.ws.model.response.RoleResponse;
import com.atheesh.app.ws.service.RoleService;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("roles")
public class RolesEntryPoint {

    @Autowired
    RoleService roleService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/status/{status}")
    public List<RoleResponse> getRolesByStatus(@PathParam("status") Status status) {
        List<RoleDTO> roleDTOList = roleService.getRolesByStatus(status);
        List<RoleResponse> roleResponseList = new ArrayList<>();

        for(RoleDTO roleDTO:roleDTOList){
            roleResponseList.add(DTOToResponseFactory.role(roleDTO));
        }

        return roleResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<RoleResponse> getAllRoles() {
        List<RoleDTO> roleDTOList = roleService.getAllRoles();
        List<RoleResponse> roleResponseList = new ArrayList<>();

        for(RoleDTO roleDTO : roleDTOList){
            roleResponseList.add(DTOToResponseFactory.role(roleDTO));
        }
        return roleResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public RoleResponse getRoleById(@PathParam("id") int id){
        RoleDTO roleDTO = roleService.getRoleById(id);
        return DTOToResponseFactory.role(roleDTO);
    }


    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public RoleResponse save(RoleRequest roleRequest) {
        RoleDTO savedRole = roleService.save(RequestToDTOFactory.role(roleRequest));
        return DTOToResponseFactory.role(savedRole);
    }

    @PUT
    @Consumes({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean update(@PathParam("id") int id, RoleRequest roleRequest) {
        return roleService.update(id, RequestToDTOFactory.role(roleRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id) {
        return roleService.delete(id);
    }

}
