package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.entities.ShopEntity;
import com.atheesh.app.ws.entities.StoreEntity;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.StoreRepository;
import com.atheesh.app.ws.service.StoreService;
import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.dto.StoreDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("storeService")
@Transactional(propagation= Propagation.REQUIRED)
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public List<StoreDTO> getAllStores() {
        List<StoreEntity> storeEntityList = storeRepository.findAll();
        List<StoreDTO> storeDTOList = new ArrayList<>();

        for(StoreEntity storeEntity : storeEntityList){
            storeDTOList.add(EntityToDTOFactory.store(storeEntity));
        }
        return storeDTOList;
    }

    @Override
    public List<StoreDTO> getStoresByShop(Integer shopId) {
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setId(shopId);

        List<StoreEntity> storeEntityList = storeRepository.findStoreEntitiesByShop(shopEntity);
        List<StoreDTO> storeDTOList = new ArrayList<>();

        for(StoreEntity storeEntity : storeEntityList){
            storeDTOList.add(EntityToDTOFactory.store(storeEntity));
        }
        return storeDTOList;
    }

    @Override
    public List<StoreDTO> getStoresByStatus(Status status) {
        List<StoreEntity> storeEntityList = storeRepository.findStoreEntitiesByStatus(status);
        List<StoreDTO> storeDTOList = new ArrayList<>();

        for(StoreEntity storeEntity : storeEntityList){
            storeDTOList.add(EntityToDTOFactory.store(storeEntity));
        }
        return storeDTOList;
    }

    @Override
    public List<StoreDTO> getStoresByItem(Integer itemId) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemId);

        List<StoreEntity> storeEntityList = storeRepository.findStoreEntitiesByItem(itemEntity);
        List<StoreDTO> storeDTOList = new ArrayList<>();

        for(StoreEntity storeEntity : storeEntityList){
            storeDTOList.add(EntityToDTOFactory.store(storeEntity));
        }
        return storeDTOList;
    }

    @Override
    public StoreDTO getStoreById(Integer id) {
        Optional<StoreEntity> storeEntityOptional = storeRepository.findById(id);

        if(storeEntityOptional.isPresent()){
            return EntityToDTOFactory.store(storeEntityOptional.get());
        }
        return null;
    }

    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        StoreEntity savedEntity = storeRepository.save(DTOToEntityFactory.store(storeDTO));
        return EntityToDTOFactory.store(savedEntity);
    }

    @Override
    public boolean update(Integer id, StoreDTO newStoreDTO) {
        ItemEntity newItem = DTOToEntityFactory.item(newStoreDTO.getItem());
        ShopEntity newShop = DTOToEntityFactory.shop(newStoreDTO.getShop());
        int affectedRows = storeRepository.updateTheStoreById(id,newItem,newShop,newStoreDTO.getAmount(),newStoreDTO.getMinLimit(),newStoreDTO.getStatus());

        return affectedRows > 0;
    }

    @Override
    public boolean delete(Integer id) {
        storeRepository.deleteById(id);
        return true;
    }
}
