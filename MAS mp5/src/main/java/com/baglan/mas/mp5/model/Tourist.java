package com.baglan.mas.mp5.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Tourist extends Person{
    @NotBlank
    @Length(min = 12, max = 12)
    @Column(unique = true)
    private String telephone;

    @ManyToOne
    private Trip trip;
}
