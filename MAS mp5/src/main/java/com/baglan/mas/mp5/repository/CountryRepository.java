package com.baglan.mas.mp5.repository;

import com.baglan.mas.mp5.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByName(String name);
}
