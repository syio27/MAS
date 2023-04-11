package com.baglan.mas.mp5;

import com.baglan.mas.mp5.model.Country;
import com.baglan.mas.mp5.model.Tourist;
import com.baglan.mas.mp5.model.Trip;
import com.baglan.mas.mp5.repository.CountryRepository;
import com.baglan.mas.mp5.repository.TouristRepository;
import com.baglan.mas.mp5.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final TripRepository tripRepository;
    private final TouristRepository touristRepository;

    @Override
    public void run(String... args) throws Exception {

        //Country - has many-to-many association with Trip entity
        //Trip - has one-to-many association with Tourist entity
        //Tourist entity extends from its superclass Person and inherits all its attributes
        //I use Data JPA to access and persist my data to H2 in memory database
        //This main class serves as DataLoader which saves test/starter data to Database

        Country country1 = Country.builder().name("Poland").build();
        Country country2 = Country.builder().name("Kazakhstan").build();

        Tourist tourist1 = Tourist.builder()
                .name("Jan")
                .surname("Kowalski")
                .age(20)
                .email("jan.kowalski@email.com")
                .telephone("+48555888141")
                .build();
        Tourist tourist2 = Tourist.builder()
                .name("Kim")
                .surname("Tae")
                .age(24)
                .email("kim.huen@email.com")
                .telephone("+48222444151")
                .build();

        Trip trip1 = Trip.builder()
                .name("Cool Summer Trip")
                .description("Bla bla bla bla bla bla bla")
                .countries(Set.of(country1, country2))
                .tourists(Set.of(tourist1, tourist2))
                .build();

        countryRepository.saveAll(List.of(country1, country2));
        touristRepository.saveAll(List.of(tourist1, tourist2));
        tripRepository.save(trip1);
    }
}
