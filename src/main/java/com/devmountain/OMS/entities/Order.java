package com.devmountain.OMS.entities;

import com.devmountain.OMS.dtos.OrderDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Cust cust;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private List<Item> itemList = new ArrayList<>();

    public Order(OrderDto orderDto)
    {
        if(orderDto.getId() != null)
            this.id = orderDto.getId();

        if(orderDto.getCust() != null)
            this.cust = orderDto.getCust();

        if(orderDto.getItemList() != null)
            this.itemList = orderDto.getItemList();
    }



}
