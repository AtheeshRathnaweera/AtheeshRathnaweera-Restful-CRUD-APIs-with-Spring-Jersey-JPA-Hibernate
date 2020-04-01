package com.atheesh.app.ws.service.impl;


import com.atheesh.app.ws.entities.CompanyEntity;
import com.atheesh.app.ws.entities.ShopEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.ShopRepository;
import com.atheesh.app.ws.service.ShopService;
import com.atheesh.app.ws.shared.dto.ShopDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("shopService")
@Transactional(propagation= Propagation.REQUIRED)
public class ShopServiceImpl implements ShopService {

    private final
    ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopDTO getShopById(Integer id) {
        Optional<ShopEntity> shopEntityOptional = shopRepository.findById(id);

        if(shopEntityOptional.isPresent()){
            return EntityToDTOFactory.shop(shopEntityOptional.get());
        }else {
            return null;
        }
    }

    @Override
    public List<ShopDTO> getAllShops() {
        List<ShopEntity> shopEntityList = shopRepository.findAll();
        List<ShopDTO> shopDTOList = new ArrayList<>();

        for(ShopEntity shopEntity : shopEntityList){
            shopDTOList.add(EntityToDTOFactory.shop(shopEntity));
        }
        return shopDTOList;
    }

    @Override
    public List<ShopDTO> getShopsByStatus(Status status) {
        List<ShopEntity> shopEntityList = shopRepository.findShopEntitiesByStatus(status);
        List<ShopDTO> shopDTOList = new ArrayList<>();

        for(ShopEntity shopEntity : shopEntityList){
            shopDTOList.add(EntityToDTOFactory.shop(shopEntity));
        }
        return shopDTOList;
    }

    @Override
    public List<ShopDTO> getShopsByManager(Integer id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);

        List<ShopEntity> shopEntityList = shopRepository.findShopEntitiesByManager(userEntity);
        List<ShopDTO> shopDTOList = new ArrayList<>();

        for(ShopEntity shopEntity : shopEntityList){
            shopDTOList.add(EntityToDTOFactory.shop(shopEntity));
        }
        return shopDTOList;
    }

    @Override
    public ShopDTO save(ShopDTO shopDTO) {
        ShopEntity shopEntity = shopRepository.save(DTOToEntityFactory.shop(shopDTO));
        return EntityToDTOFactory.shop(shopEntity);
    }

    @Override
    public boolean update(Integer id, ShopDTO shopDTO) {
        CompanyEntity companyEntity = DTOToEntityFactory.company(shopDTO.getCompany());
        UserEntity managerEntity = DTOToEntityFactory.user(shopDTO.getManager());

        int affectedRows = shopRepository.updateTheShopById(id,shopDTO.getName(),shopDTO.getEmail(),shopDTO.getPhoneNumber(),shopDTO.getDistrict(),
                shopDTO.getTown(),shopDTO.getAddress(),companyEntity,managerEntity,shopDTO.getStatus());

        return affectedRows > 0;
    }

    @Override
    public boolean delete(Integer id) {
        shopRepository.deleteById(id);
        return true;
    }
}
