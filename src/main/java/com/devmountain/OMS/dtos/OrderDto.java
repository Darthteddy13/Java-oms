package com.devmountain.OMS.dtos;


import com.devmountain.OMS.entities.Cust;
import com.devmountain.OMS.entities.Item;
import com.devmountain.OMS.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private Cust cust;

    private List<Item> itemList = new ArrayList<>();

    public OrderDto(Order order)
    {
        if(order.getId() != null)
            this.id = order.getId();

        if(order.getCust() != null)
            this.cust = order.getCust();
    }
}
