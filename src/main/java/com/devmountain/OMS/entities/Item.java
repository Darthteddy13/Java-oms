package com.devmountain.OMS.entities;

import com.devmountain.OMS.dtos.ItemDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer price;

    @ManyToOne
    @JsonBackReference
    private Order order;

    public Item(ItemDto itemDto)
    {
        if(itemDto.getName() != null)
            this.name = itemDto.getName();

        if(itemDto.getDescription() != null)
            this.description = itemDto.getDescription();

        if(itemDto.getPrice() != null)
            this.price = itemDto.getPrice();
    }


}
