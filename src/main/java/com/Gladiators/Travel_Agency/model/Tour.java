package com.Gladiators.Travel_Agency.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tour")
@Builder
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city ;
    private LocalDateTime startDay;
    private LocalDateTime returnDay;
    private Double adultPrice;
    private Double childPrice;
    private int adultSeatsNumber;
    private int childSeatsNumber;
    private String hotel;

}
