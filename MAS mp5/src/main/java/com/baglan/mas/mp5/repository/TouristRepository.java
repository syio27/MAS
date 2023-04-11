package com.baglan.mas.mp5.repository;

import com.baglan.mas.mp5.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Tourist findByTelephone(String telephone);
}
