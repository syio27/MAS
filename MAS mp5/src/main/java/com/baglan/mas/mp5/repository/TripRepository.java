package com.baglan.mas.mp5.repository;

import com.baglan.mas.mp5.model.Country;
import com.baglan.mas.mp5.model.Tourist;
import com.baglan.mas.mp5.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllByName(String name);
    List<Trip> findAllByDateFrom(LocalDate dateFrom);
    List<Trip> findAllByDateTo(LocalDate dateTo);
}
