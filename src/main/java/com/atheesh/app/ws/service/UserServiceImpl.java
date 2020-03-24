package com.atheesh.app.ws.service;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.repositories.UserRepository;
import com.atheesh.app.ws.shared.dto.UserDto;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional(propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void init() {
    }

    public String save(UserDto newUser) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(newUser, userEntity);

        // Perform needed validation and other required business logic here
        // Set other required fields like enctypted password for example
        String encryptedPassword = "encrypted password here";

        userEntity.setEncryptedPassword(encryptedPassword);

        try {
            UserEntity recUser = userRepository.save(userEntity);
            if(recUser != null){
                return "Save Success.";
            }else{
                return "Save Failed.";
            }
        } catch (Exception ex) {
            System.out.println("user save failed.");
            return "Save Failed.";
        }
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> returnValue = new ArrayList();

        List<UserEntity> foundRecords = Lists.newArrayList(userRepository.findAll());

        for(UserEntity userEntity:foundRecords)
        {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }

        return returnValue;
    }
}
