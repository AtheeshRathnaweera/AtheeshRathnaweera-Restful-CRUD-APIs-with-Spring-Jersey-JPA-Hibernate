package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.repositories.RoleRepository;
import com.atheesh.app.ws.service.RoleService;
import com.atheesh.app.ws.shared.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.atheesh.app.ws.factory.RoleFactory.convertDTOToEntity;
import static com.atheesh.app.ws.factory.RoleFactory.convertEntityToDTO;

@Service("roleService")
@Transactional(propagation= Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleDTO getRoleById(Integer id) {
        Optional<RoleEntity> recRoleOp = roleRepository.findById(id);

        if (recRoleOp.isPresent()) {
            RoleEntity role = recRoleOp.get();
            return convertEntityToDTO(role);
        } else {
            return null;
        }
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();

        for(RoleEntity roleEntity : roleEntityList){
            roleDTOList.add(convertEntityToDTO(roleEntity));
        }
        return roleDTOList;
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        RoleEntity roleEntity = roleRepository.save(convertDTOToEntity(roleDTO));
        return convertEntityToDTO(roleEntity);
    }

    @Override
    public boolean update(Integer id, RoleDTO roleDTO) {
        System.out.println("update service name : "+roleDTO.getName());
        int affectedRows = roleRepository.updateTheRoleById(id, roleDTO.getName());
        if(affectedRows > 0){
            return true;
        }else{
           return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        roleRepository.deleteById(id);
        return true;
    }
}
