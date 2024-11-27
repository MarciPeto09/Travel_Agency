package com.Gladiators.Travel_Agency.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestReviewDto {

        private String description;
        private LocalDateTime Data;
        private Integer Number;

        private Long tourId;


    }
