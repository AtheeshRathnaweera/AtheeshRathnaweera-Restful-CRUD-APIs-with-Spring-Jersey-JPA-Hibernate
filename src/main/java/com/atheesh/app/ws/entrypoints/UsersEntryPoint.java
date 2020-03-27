package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;



@Component
@Path("users")
public class UsersEntryPoint {

    @Autowired
    UserService userService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/status/{status}")
    public List<UserResponse> getUsersByStatus(@PathParam("status") UserStatus status) {
        List<UserDTO> usersResList = userService.getUsersByStatus(status);
        List<UserResponse> userResponseList = new ArrayList<>();

        for(UserDTO userDTO : usersResList ){
            userResponseList.add(convertDTOTOResponse(userDTO));
        }
        return userResponseList;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/all")
    public List<UserResponse> getAllUsers() {
        List<UserDTO> usersList = userService.getAllUsers();
        List<UserResponse> usersResList = new ArrayList<>();

        for(UserDTO user:usersList){
            usersResList.add(convertDTOTOResponse(user));
        }

        return usersResList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserResponse getUserById(@PathParam("id") int id) {
        UserDTO user = userService.getUserById(id);
        return convertDTOTOResponse(user);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    public UserResponse save(UserRequest userRequest) {
        UserDTO savedUser = userService.save(convertRequestToDTO(userRequest));
        return convertDTOTOResponse(savedUser);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.TEXT_PLAIN} )
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, UserRequest userRequest) {
        return userService.update(id, convertRequestToDTO(userRequest));
    }

    @DELETE
    @Produces({ MediaType.TEXT_PLAIN} )
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id){
        return userService.delete(id);
    }

    //conversion methods
    private UserResponse convertDTOTOResponse(UserDTO userDTO){
        return (UserResponse) ConversionFactory.conversion(userDTO,new UserResponse());
    }

    private UserDTO convertRequestToDTO(UserRequest userRequest){
        return (UserDTO) ConversionFactory.conversion(userRequest,new UserDTO());
    }
    //conversion methods



}
