package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.UserDto;

import java.util.List;

public interface UserService{

    public String save(UserDto newUser);
    public List<UserDto> getAllUsers();

}