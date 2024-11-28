package com.Gladiators.Travel_Agency.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tours")
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
    private Integer adultSeatsNumber;
    private Integer childSeatsNumber;
    private String hotel;


   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "category_Id", nullable = false)
    Category category;


   @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
   List<Review> listOfReview;
}
