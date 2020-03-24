package com.atheesh.app.ws.entrypoints;


import com.atheesh.app.ws.model.request.SaveUserRequest;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("users")
public class UsersEntryPoint {

    @Autowired
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();

    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String save(SaveUserRequest saveUserRequest) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(saveUserRequest, userDto);
        return userService.save(userDto);
    }
}
