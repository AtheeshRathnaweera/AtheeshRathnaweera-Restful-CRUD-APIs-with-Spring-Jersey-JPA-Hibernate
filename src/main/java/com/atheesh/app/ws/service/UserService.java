package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.UserDTO;

import java.util.List;

public interface UserService{

    UserDTO getUserById(Integer id);
    List<UserDTO> getAllUsers();
    UserDTO save(UserDTO userDTO);
    boolean update(Integer id, UserDTO userDTO);
    boolean delete(Integer id);
    String test();


}