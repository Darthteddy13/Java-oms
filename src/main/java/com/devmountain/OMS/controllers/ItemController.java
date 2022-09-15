package com.devmountain.OMS.controllers;

import com.devmountain.OMS.dtos.ItemDto;
import com.devmountain.OMS.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/order/{orderId}")
    public List<ItemDto> getItemsByOrder(@PathVariable Long id)
    {
        return itemService.getAllItemInOrder(id);
    }

    @PostMapping("order/{orderId}")
    public void addItem(@RequestBody ItemDto itemDto, @PathVariable Long id)
    {
        itemService.addItem(itemDto, id);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItemById(@PathVariable Long id)
    {
        itemService.deleteItemById(id);
    }

    @PutMapping
    public void updateitem(@RequestBody ItemDto itemDto)
    {
        itemService.updateItemById(itemDto);
    }

    @GetMapping("/{itemId}")
    public Optional<ItemDto> getItemById(@PathVariable Long id)
    {
        return itemService.getByItemId(id);
    }

}
