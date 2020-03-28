package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.UserRoleRequest;
import com.atheesh.app.ws.model.response.RoleResponse;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.model.response.UserRoleResponse;
import com.atheesh.app.ws.service.UserRoleService;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("userroles")
public class UserRoleEntryPoint {

    @Autowired
    UserRoleService userRoleService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<UserRoleResponse> getAllUserRoles() {
        List<UserRoleDTO> userRoleDTOList = userRoleService.getAllUserRoles();
        List<UserRoleResponse> userRoleResponseList = new ArrayList<>();

        for(UserRoleDTO userRoleDTO : userRoleDTOList){
            userRoleResponseList.add(convertDTOToResponse(userRoleDTO));
        }

        return userRoleResponseList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserRoleResponse getUserRoleById(@PathParam("id") Integer id) {
        UserRoleDTO userRoleDTO = userRoleService.getUserRoleById(id);
        return convertDTOToResponse(userRoleDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}")
    public List<UserRoleResponse> getUserRolesByUser(@PathParam("id") Integer id) {
        List<UserRoleDTO> userRoleDTOList = userRoleService.getUserRolesByUser(id);
        List<UserRoleResponse> userRoleResponseList = new ArrayList<>();

        for(UserRoleDTO userRoleDTO : userRoleDTOList){
            userRoleResponseList.add(convertDTOToResponse(userRoleDTO));
        }

        return userRoleResponseList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/role/{roleName}")
    public List<UserRoleResponse> getUserRolesByRole(@PathParam("roleName") String roleName) {
        List<UserRoleDTO> userRoleDTOList = userRoleService.getUserRolesByRole(roleName);
        List<UserRoleResponse> userRoleResponseList = new ArrayList<>();

        for(UserRoleDTO userRoleDTO : userRoleDTOList){
            userRoleResponseList.add(convertDTOToResponse(userRoleDTO));
        }

        return userRoleResponseList;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    public UserRoleResponse save(UserRoleRequest userRoleRequest) {
        UserRoleDTO savedUserRoleDTO = userRoleService.save(convertRequestToDTO(userRoleRequest));
        return convertDTOToResponse(savedUserRoleDTO);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id,UserRoleRequest userRoleRequest){
        System.out.println("update request received");
        return userRoleService.update(id,convertRequestToDTO(userRoleRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public boolean delete(@PathParam("id") Integer id){
        return userRoleService.delete(id);
    }


    private UserRoleDTO convertRequestToDTO(UserRoleRequest userRoleRequest){

        UserDTO newUser = new UserDTO();
        newUser.setId(userRoleRequest.getUserId());

        RoleDTO newRole = new RoleDTO();
        newRole.setName(userRoleRequest.getRoleName());

        return new UserRoleDTO(null,newUser,newRole);

    }

    private UserRoleResponse convertDTOToResponse(UserRoleDTO userRoleDTO){

        UserResponse userResponse = new UserResponse(userRoleDTO.getUser().getId());
        RoleResponse roleResponse = new RoleResponse(userRoleDTO.getRole().getId());

        return new UserRoleResponse(userRoleDTO.getId(),userResponse,roleResponse);

    }
}
