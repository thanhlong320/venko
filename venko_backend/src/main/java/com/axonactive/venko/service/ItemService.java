package com.axonactive.venko.service;

import com.axonactive.venko.entity.Item;
import com.axonactive.venko.service.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> findAll();
    ItemDTO update(Item item);
    ItemDTO add(Item item);
    void delete(Integer itemId);
}
