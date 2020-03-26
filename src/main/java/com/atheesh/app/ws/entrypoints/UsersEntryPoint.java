package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
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
    public String getAllUsers() {
        System.out.println("get all users started.");

        String testWe = userService.test();
        System.out.println(testWe);
        List<UserDTO> usersList = userService.getAllUsers();
        System.out.println("found users : "+usersList.size());
        return testWe;
//
//        List<UserResponse> usersResList = new ArrayList<>();
//
//        for(UserDTO user:usersList){
//            System.out.println("user : "+user.toString());
//            usersResList.add(convertDTOToResponse(user));
//        }
//
//        return usersResList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UserResponse getUserById(@PathParam("id") int id) {
        System.out.println("get user by id started");
        UserDTO user = userService.getUserById(id);
        return convertDTOToResponse(user);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    public UserResponse save(UserRequest userRequest) {
        System.out.println("user save method started. "+userRequest.toString());
        UserDTO savedUser = userService.save(convertUserRequestToDTO(userRequest));
        return convertDTOToResponse(savedUser);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON} )
    @Produces({ MediaType.APPLICATION_JSON} )
    @Path("/{id}")
    public UserResponse update(@PathParam("id") int id, UserRequest userRequest) {
        System.out.println("user update started "+id);
        return new UserResponse();
    }

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/{id}")
    public boolean delete(@PathParam("id") int id){
        return userService.delete(id);
    }

}
