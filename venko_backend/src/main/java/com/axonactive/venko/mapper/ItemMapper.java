package com.axonactive.venko.mapper;

import com.axonactive.venko.controller.request.ItemRequest;
import com.axonactive.venko.entity.Item;
import com.axonactive.venko.service.dto.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    Item toEntity(ItemRequest itemRequest);
    ItemDTO toDTO(Item item);
    List<ItemDTO> toDTOs(List<Item> items);
}
