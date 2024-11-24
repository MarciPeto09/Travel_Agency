package com.Gladiators.Travel_Agency.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReviewDto {

    private Long id;
    private String description;
    private LocalDateTime Data;
    private Integer Number;
}
