package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.DTOToResponseFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.ItemRepository;
import com.atheesh.app.ws.service.ItemService;
import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("itemService")
@Transactional(propagation= Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemDTO getItemById(Integer id) {
        Optional<ItemEntity> recItem = itemRepository.findById(id);

        if(recItem.isPresent()){
            return EntityToDTOFactory.item(recItem.get());
        }
        return null;
    }

    @Override
    public List<ItemDTO> getItemByStatus(Status status) {
        List<ItemEntity> itemEntityList = itemRepository.findItemEntityByStatusEquals(status);
        List<ItemDTO> itemDTOList = new ArrayList<>();

        for(ItemEntity itemEntity : itemEntityList){
            itemDTOList.add(EntityToDTOFactory.item(itemEntity));
        }
        return itemDTOList;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        for(ItemEntity itemEntity : itemEntityList){
            itemDTOList.add(EntityToDTOFactory.item(itemEntity));
        }

        return itemDTOList;
    }

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        System.out.println("received new item : "+itemDTO.toString());
        itemDTO.setCreatedDate(new Date());
        itemDTO.setUpdatedDate(new Date());
        ItemEntity savedItem = itemRepository.save(DTOToEntityFactory.item(itemDTO));
        return EntityToDTOFactory.item(savedItem);
    }

    @Override
    public boolean update(Integer id, ItemDTO itemDTO) {
        int affectedRows = itemRepository.updateTheItemById(id,itemDTO.getName(),itemDTO.getImageUrl(),itemDTO.getStatus(),new Date());

        return affectedRows > 0;
    }

    @Override
    public boolean delete(Integer id) {
        itemRepository.deleteById(id);
        return true;
    }

}
