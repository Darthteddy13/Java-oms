package com.devmountain.OMS.repos;


import com.devmountain.OMS.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devmountain.OMS.entities.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOrderEquals(Order order);
}
