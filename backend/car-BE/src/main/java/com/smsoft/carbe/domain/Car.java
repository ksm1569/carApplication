package com.smsoft.carbe.domain;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand, model, color, registerNumber;
    private int manufactureYear, price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;
}
