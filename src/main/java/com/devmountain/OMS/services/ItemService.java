package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.ItemDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    @Transactional
    void addItem(ItemDto itemDto, long id);

    @Transactional
    void deleteItemById(Long id);

    @Transactional
    void updateItemById(ItemDto itemDto);

    List<ItemDto> getAllItemInOrder(Long id);

    Optional<ItemDto> getByItemId(Long id);
}
