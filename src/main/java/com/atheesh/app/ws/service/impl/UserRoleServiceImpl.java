package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.entities.UserRoleEntity;
import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.RoleRepository;
import com.atheesh.app.ws.repositories.UserRoleRepository;
import com.atheesh.app.ws.service.UserRoleService;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userRoleService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserRoleDTO getUserRoleById(Integer id) {
        Optional<UserRoleEntity> userRoleEntityOptional = userRoleRepository.findById(id);
        return userRoleEntityOptional.map(EntityToDTOFactory::userRole).orElse(null);
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRoleEntity> userRoleEntityList = userRoleRepository.findAll();
        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();

        for(UserRoleEntity userRoleEntity : userRoleEntityList){
            userRoleDTOList.add(EntityToDTOFactory.userRole(userRoleEntity));
        }
        return userRoleDTOList;
    }

    @Override
    public List<UserRoleDTO> getUserRolesByUser(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        List<UserRoleEntity> userRoleEntityList = userRoleRepository.findUserRoleEntitiesByUser(userEntity);
        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();

        for(UserRoleEntity userRoleEntity : userRoleEntityList){
            userRoleDTOList.add(EntityToDTOFactory.userRole(userRoleEntity));
        }
        return userRoleDTOList;
    }

    @Override
    public List<UserRoleDTO> getUserRolesByRole(String roleName) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByName(roleName);
        List<UserRoleEntity> userRoleEntityList = userRoleRepository.findUserRoleEntitiesByRole(roleEntity);
        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();

        for(UserRoleEntity userRoleEntity : userRoleEntityList){
            userRoleDTOList.add(EntityToDTOFactory.userRole(userRoleEntity));
        }
        return userRoleDTOList;
    }

    @Override
    public UserRoleDTO save(UserRoleDTO userRoleDTO) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByName(userRoleDTO.getRole().getName());
        UserEntity userEntity = (UserEntity) ConversionFactory.conversion(userRoleDTO.getUser(),new UserEntity());

        if(roleEntity == null){
            return null;
        }

        UserRoleEntity savedUserRole = userRoleRepository.save(new UserRoleEntity(userEntity,roleEntity));
        return EntityToDTOFactory.userRole(savedUserRole);
    }

    @Override
    public boolean update(Integer id, UserRoleDTO userRoleDTO) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByName(userRoleDTO.getRole().getName());
        int affectedRows = userRoleRepository.updateTheUserRoleById(id,roleEntity,DTOToEntityFactory.user(userRoleDTO.getUser()));

        if(affectedRows > 0){
           return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        userRoleRepository.deleteById(id);
        return true;
    }



}
