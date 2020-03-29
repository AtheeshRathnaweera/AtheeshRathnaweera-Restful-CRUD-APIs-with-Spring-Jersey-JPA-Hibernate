package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.ShopDTO;
import com.atheesh.app.ws.shared.enums.Status;

import java.util.List;

public interface ShopService {

    ShopDTO getShopById(Integer id);
    List<ShopDTO> getAllShops();
    List<ShopDTO> getShopsByStatus(Status status);
    List<ShopDTO> getShopsByManager(Integer id);
    ShopDTO save(ShopDTO shopDTO);
    boolean update(Integer id, ShopDTO shopDTO);
    boolean delete(Integer id);
}
