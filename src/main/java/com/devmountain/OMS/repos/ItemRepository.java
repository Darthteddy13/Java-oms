package com.devmountain.OMS.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devmountain.OMS.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
