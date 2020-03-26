package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.UserDTO;

import java.util.List;

public interface UserService{

    UserDTO getUserById(int id);
    List<UserDTO> getAllUsers();
    UserDTO save(UserDTO userDTO);
    UserDTO update(int id, UserDTO userDTO);
    boolean delete(int id);
    String test();


}