package com.devmountain.OMS.dtos;


import com.devmountain.OMS.entities.Item;
import com.devmountain.OMS.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto  implements Serializable {

    private long id;

    private String name;

    private String description;

    private Integer price;

    public ItemDto(Item item)
    {
        if(item.getName() != null)
            this.name = item.getName();

        if(item.getDescription() != null)
            this.description = item.getDescription();

        if(item.getPrice() != null)
            this.price = item.getPrice();

    }

}
