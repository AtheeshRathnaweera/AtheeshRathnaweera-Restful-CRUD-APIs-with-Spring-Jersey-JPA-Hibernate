package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.StoreDTO;
import com.atheesh.app.ws.shared.enums.Status;

import java.util.List;

public interface StoreService {

    List<StoreDTO> getAllStores();
    List<StoreDTO> getStoresByShop(Integer shopId);
    List<StoreDTO> getStoresByStatus(Status status);
    List<StoreDTO> getStoresByItem(Integer itemId);
    StoreDTO getStoreById(Integer id);
    StoreDTO save(StoreDTO storeDTO);
    boolean update(Integer id, StoreDTO newStoreDTO);
    boolean delete(Integer id);



}
