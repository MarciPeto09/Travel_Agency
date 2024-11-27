package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.model.Review;
import com.Gladiators.Travel_Agency.model.Tour;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class MapperTour {

   private  MapperReview mapperReview;

    public Tour mapToEntity(RequestTourDto requestTourDto) {
        Tour tourEntity = Tour.builder()
                .city(requestTourDto.getCity())
                .hotel(requestTourDto.getHotel())
                .adultPrice(requestTourDto.getAdultPrice())
                .adultSeatsNumber(requestTourDto.getAdultSeatsNumber())
                .childPrice(requestTourDto.getChildPrice())
                .childSeatsNumber(requestTourDto.getChildSeatsNumber())
                .returnDay(requestTourDto.getReturnDay())
                .startDay(requestTourDto.getStartDay())
                .build();

        return tourEntity;
    }


    public ResponseTourDto mapToResponse (Tour tour){
        ResponseTourDto responsTourDto = new ResponseTourDto();
        responsTourDto.setId(tour.getId());
        responsTourDto.setCity(tour.getCity());
        responsTourDto.setHotel(tour.getHotel());
        responsTourDto.setAdultPrice(tour.getAdultPrice());
        responsTourDto.setChildPrice(tour.getChildPrice());
        responsTourDto.setReturnDay(tour.getReturnDay());
        responsTourDto.setStartDay(tour.getStartDay());
        responsTourDto.setAdultSeatsNumber(tour.getAdultSeatsNumber());
        responsTourDto.setChildSeatsNumber(tour.getChildSeatsNumber());
        responsTourDto.setCategoryName(String.valueOf(tour.getCategory().getType()));

       List<Review> listReview =  tour.getListOfReview();
       if (listReview != null) {
           responsTourDto.setListOfReview(listReview.stream()
                   .map(r -> mapperReview.mapToRespons(r))
                   .toList());
       }else{
           responsTourDto.setListOfReview(Collections.emptyList());
       }

        return responsTourDto;
    }
}
