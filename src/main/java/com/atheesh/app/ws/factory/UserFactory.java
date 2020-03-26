package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.model.request.UserRequest;
import com.atheesh.app.ws.model.response.UserResponse;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;

import static com.atheesh.app.ws.factory.RoleFactory.convertDTOToEntity;
import static com.atheesh.app.ws.factory.RoleFactory.convertRequestToDTO;
import static com.atheesh.app.ws.factory.RoleFactory.convertEntityToDTO;
import static com.atheesh.app.ws.factory.RoleFactory.convertDTOTOResponse;

public class UserFactory {

    public static UserDTO convertUserRequestToDTO(UserRequest userRequest){
        if(userRequest != null) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userRequest, userDTO);
            userDTO.setRole(convertRequestToDTO(userRequest.getRole()));
            return userDTO;
        }else{
            return null;
        }
    }

    public static UserResponse convertDTOToResponse(UserDTO userDTO){

        System.out.println("user response creation started");

        if(userDTO != null) {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(userDTO, userResponse);
            userResponse.setRole(convertDTOTOResponse(userDTO.getRole()));
            System.out.println("user response creation ended : " + userResponse.toString());
            return userResponse;
        }else{
            return null;
        }
    }

    public static UserDTO convertUserEntityToDTO(UserEntity userEntity){
        System.out.println("convery user entity to dto started :");
        if(userEntity != null) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            userDTO.setRole(convertEntityToDTO(userEntity.getRole()));
            System.out.println("convery user entity to dto end : " + userDTO.toString());
            return userDTO;
        }else{
            return null;
        }
    }

    public static UserEntity convertUserDTOtoEntity(UserDTO userDTO){
        if(userDTO != null) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDTO, userEntity);
            userEntity.setRole(convertDTOToEntity(userDTO.getRole()));
            return userEntity;
        }else{
            return null;
        }
    }
}
