package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.RoleRequest;
import com.atheesh.app.ws.model.response.RoleResponse;
import com.atheesh.app.ws.service.RoleService;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.atheesh.app.ws.factory.RoleFactory.convertDTOTOResponse;
import static com.atheesh.app.ws.factory.RoleFactory.convertRequestToDTO;

@Component
@Path("roles")
public class RolesEntryPoint {

    @Autowired
    RoleService roleService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    public List<RoleResponse> getAllActiveRoles() {
        List<RoleResponse> roleResponseList = new ArrayList<>();
        return roleResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<RoleResponse> getAllRoles() {
        List<RoleDTO> roleDTOList = roleService.getAllRoles();
        List<RoleResponse> roleResponseList = new ArrayList<>();

        for(RoleDTO roleDTO : roleDTOList){
            roleResponseList.add(convertDTOTOResponse(roleDTO));
        }
        return roleResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public RoleResponse getRoleById(@PathParam("id") int id){
        RoleDTO roleDTO = roleService.getRoleById(id);
        return convertDTOTOResponse(roleDTO);
    }


    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public RoleResponse save(RoleRequest roleRequest) {
        RoleDTO roleDTO = roleService.save(convertRequestToDTO(roleRequest));
        return convertDTOTOResponse(roleDTO);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public boolean update(@PathParam("id") int id, RoleRequest roleRequest) {
        System.out.println("id :"+id+" role : "+roleRequest.toString());
        RoleDTO roleDTO = convertRequestToDTO(roleRequest);
        return roleService.update(id, roleDTO);
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id) {
        return roleService.delete(id);
    }
}
