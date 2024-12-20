package com.Gladiators.Travel_Agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTourDto {

    private Long id;
    private String city ;
    private LocalDateTime startDay;
    private LocalDateTime returnDay;
    private Double adultPrice;
    private Double childPrice;
    private int adultSeatsNumber;
    private int childSeatsNumber;
    private String hotel;

    private String categoryName;

    private List<ResponseReviewDto> listOfReview;
}
