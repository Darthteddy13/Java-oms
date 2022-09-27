package com.devmountain.OMS.controllers;

import com.devmountain.OMS.dtos.ItemDto;
import com.devmountain.OMS.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/order/{orderId}")
    public List<ItemDto> getItemsByOrder(@PathVariable Long orderId)
    {
        return itemService.getAllItemInOrder(orderId);
    }

    @PostMapping("order/{orderId}")
    public void addItem(@RequestBody ItemDto itemDto, @PathVariable Long orderId)
    {
        itemService.addItem(itemDto, orderId);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItemById(@PathVariable Long itemId)
    {
        itemService.deleteItemById(itemId);
    }

    @PutMapping
    public void updateItem(@RequestBody ItemDto itemDto)
    {
        itemService.updateItemById(itemDto);
    }

    @GetMapping("/{itemId}")
    public Optional<ItemDto> getItemById(@PathVariable Long itemId)
    {
        return itemService.getByItemId(itemId);
    }

}
