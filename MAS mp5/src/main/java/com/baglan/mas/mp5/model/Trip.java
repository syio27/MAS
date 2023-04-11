package com.baglan.mas.mp5.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(length = 120, nullable = false)
    private String name;
    @NotBlank
    @Column(length = 255, nullable = false)
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;
    @Max(100)
    private static int maxPeople;

    @ManyToMany
    private Set<Country> countries;
    @OneToMany(mappedBy = "trip")
    private Set<Tourist> tourists;
}
