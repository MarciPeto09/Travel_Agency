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
        ResponseTourDto responseTourDto = new ResponseTourDto();
        responseTourDto.setId(tour.getId());
        responseTourDto.setCity(tour.getCity());
        responseTourDto.setHotel(tour.getHotel());
        responseTourDto.setAdultPrice(tour.getAdultPrice());
        responseTourDto.setChildPrice(tour.getChildPrice());
        responseTourDto.setReturnDay(tour.getReturnDay());
        responseTourDto.setStartDay(tour.getStartDay());
        responseTourDto.setAdultSeatsNumber(tour.getAdultSeatsNumber());
        responseTourDto.setChildSeatsNumber(tour.getChildSeatsNumber());
        responseTourDto.setCategoryName(String.valueOf(tour.getCategory().getType()));

       List<Review> listReview =  tour.getListOfReview();
       if (listReview != null) {
           responseTourDto.setListOfReview(listReview.stream()
                   .map(r -> mapperReview.mapToRespons(r))
                   .toList());
       }else{
           responseTourDto.setListOfReview(Collections.emptyList());
       }

        return responseTourDto;
    }
}
