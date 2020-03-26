package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO getItemById(Integer id);
    List<ItemDTO> getAllItems();
    ItemDTO save(Integer id, ItemDTO itemDTO);
    boolean update(Integer id, ItemDTO itemDTO);
    boolean delete(Integer id);
}
