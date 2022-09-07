package com.devmountain.OMS.dtos;


import com.devmountain.OMS.entities.Cust;
import com.devmountain.OMS.entities.Item;
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

    private List<Item> itemDtoList = new ArrayList<>();
}
