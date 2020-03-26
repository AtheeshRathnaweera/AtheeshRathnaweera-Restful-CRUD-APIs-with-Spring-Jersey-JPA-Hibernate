package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.factory.UserFactory;
import com.atheesh.app.ws.repositories.UserRepository;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.atheesh.app.ws.factory.UserFactory.convertUserDTOtoEntity;
import static com.atheesh.app.ws.factory.UserFactory.convertUserEntityToDTO;

@Service("userService")
@Transactional(propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void init() {
    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<UserEntity> recUserOp = userRepository.findById(id);

        if (recUserOp.isPresent()) {
            return convertUserEntityToDTO(recUserOp.get());
        }else{
            return null;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> returnValue = new ArrayList();

        List<UserEntity> foundRecords = Lists.newArrayList(userRepository.findAll());

        for(UserEntity userEntity:foundRecords)
        {
            returnValue.add(convertUserEntityToDTO(userEntity));
        }

        System.out.println("in getall users : "+returnValue.size());

        return returnValue;
    }

    @Override
    public UserDTO save(UserDTO newUser) {
        Date nowDate = new Date();
        newUser.setCreatedDate(nowDate);

        UserEntity userEntity = convertUserDTOtoEntity(newUser);
       // userEntity.getRole().setId(1);
        System.out.println("user before saved : entity : "+userEntity.toString());
        UserEntity savedUser = userRepository.save(userEntity);
        System.out.println("saved user " + savedUser.toString());
        return convertUserEntityToDTO(savedUser);
    }

    @Override
    public UserDTO update(int id, UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public String test() {
        return "test work";
    }


}
