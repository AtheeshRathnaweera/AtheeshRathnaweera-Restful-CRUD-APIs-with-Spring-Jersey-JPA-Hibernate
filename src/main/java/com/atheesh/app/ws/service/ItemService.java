package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.ItemDTO;
import com.atheesh.app.ws.shared.enums.Status;

import java.util.List;

public interface ItemService {

    List<ItemDTO> getAllItems();
    ItemDTO getItemById(Integer id);
    List<ItemDTO> getItemByStatus(Status status);
    ItemDTO save(ItemDTO itemDTO);
    boolean update(Integer id, ItemDTO itemDTO);
    boolean delete(Integer id);
}
