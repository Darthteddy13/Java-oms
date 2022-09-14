package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.ItemDto;
import com.devmountain.OMS.entities.Item;
import com.devmountain.OMS.entities.Order;
import com.devmountain.OMS.repos.CustRepository;
import com.devmountain.OMS.repos.ItemRepository;
import com.devmountain.OMS.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void addItem(ItemDto itemDto, long id)
    {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Item item = new Item(itemDto);
        orderOptional.ifPresent(item::setOrder);
        itemRepository.saveAndFlush(item);
    }

    @Override
    @Transactional
    public void deleteItemById(Long id)
    {
        Optional<Item> itemOptional = itemRepository.findById(id);
        itemOptional.ifPresent(itemRepository::delete);
    }

    @Override
    @Transactional
    public void updateItemById(ItemDto itemDto)
    {
        Optional<Item> itemOptional = itemRepository.findById(itemDto.getId());
        itemOptional.ifPresent(item ->
        {
            item.setDescription(itemDto.getDescription());
            item.setName(itemDto.getName());
            item.setPrice(itemDto.getPrice());
            itemRepository.saveAndFlush(item);
        });
    }


    @Override
    public List<ItemDto> getAllItemInOrder(Long id)
    {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent())
        {
            List<Item> itemList = itemRepository.findAllByOrderEquals(orderOptional.get());
            return itemList.stream().map(item -> new ItemDto(item)).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<ItemDto> getByItemId(Long id)
    {
        Optional<Item> itemOptional = itemRepository.findById(id);

        if(itemOptional.isPresent())
            return Optional.of(new ItemDto(itemOptional.get()));

        return Optional.empty();
    }


}
