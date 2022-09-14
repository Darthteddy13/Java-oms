package com.devmountain.OMS.repos;

import com.devmountain.OMS.entities.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustRepository extends JpaRepository<Cust, Long> {

    Optional<Cust> findByName(String name);
}
