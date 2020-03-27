package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.jws.soap.SOAPBinding;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static com.atheesh.app.ws.factory.UserFactory.convertDTOToResponse;
import static com.atheesh.app.ws.factory.UserFactory.convertUserRequestToDTO;

@Component
@Path("users")
public class UsersEntryPoint {

    @Autowired
    UserService userService;

    @GET
    public List<UserResponse> getAllUsers() {
        List<UserDTO> usersList = userService.getAllUsers();
        List<UserResponse> usersResList = new ArrayList<>();

        for(UserDTO user:usersList){
            usersResList.add(convertDTOToResponse(user));
        }

        return usersResList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserResponse getUserById(@PathParam("id") int id) {
        UserDTO user = userService.getUserById(id);
        return convertDTOToResponse(user);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    public UserResponse save(UserRequest userRequest) {
        UserDTO savedUser = userService.save(convertUserRequestToDTO(userRequest));
        return convertDTOToResponse(savedUser);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public boolean update(@PathParam("id") Integer id, UserRequest userRequest) {
        return userService.update(id,convertUserRequestToDTO(userRequest));
    }

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id){
        return userService.delete(id);
    }



}
