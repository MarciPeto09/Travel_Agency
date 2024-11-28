package com.Gladiators.Travel_Agency.service;


import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.mapper.MapperTour;
import com.Gladiators.Travel_Agency.model.Category;
import com.Gladiators.Travel_Agency.model.Review;
import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.repository.CategoryRepo;
import com.Gladiators.Travel_Agency.repository.ReviewRepo;
import com.Gladiators.Travel_Agency.repository.TourRepository;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TourService {


    private TourRepository tourRepo;
    private MapperTour mapper;
    private CategoryRepo categoryRepo;
    private ReviewRepo reviewRepo;



    public List<ResponseTourDto> findAll(){
      List<Tour> listTour = tourRepo.findAll();
        return listTour.stream().map(t -> mapper.mapToResponse(t))
                .toList();
    }

    public  ResponseTourDto getTourById(Long id)  {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("This tour id does not exist!"));
        return mapper.mapToResponse(tour);
    }

    public void deleteTourById(Long id){
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("This tour id does not exist!"));

        if(existingTour != null){
            tourRepo.delete(existingTour);
        }else{
            throw new RuntimeException("This tour id does not exist!");
        }
    }

    public ResponseTourDto save(RequestTourDto request) {
        Category categoryExist = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        Tour tour = mapper.mapToEntity(request);
        tour.setCategory(categoryExist);

        Tour savedTour = tourRepo.save(tour);

        return mapper.mapToResponse(savedTour);

    }


    public List<ResponseTourDto> getToursBetweenDates(LocalDateTime startDay, LocalDateTime returnDay){
        List<Tour> tourList = tourRepo.getToursBetweenDates(startDay, returnDay);
        return tourList.stream()
                .map(t -> mapper.mapToResponse(t))
                .toList();
    }


    public List<ResponseTourDto> findByCityAndStartDayAndReturnDayAndAdultPriceAndChildPriceAndAdultSeatsNumberAndChildSeatsNumberAndHotel(@Nullable String city,
                                                                                                                                           @Nullable Double adultPrice, @Nullable Double childPrice, @Nullable int adultSeatsNumber, @Nullable int childSeatsNumber, @Nullable String hotel) {
        List<Tour> listOfTours = tourRepo.findByCityAndStartDayAndReturnDayAndAdultPriceAndChildPriceAndAdultSeatsNumberAndChildSeatsNumberAndHotel(city, adultPrice, childPrice, adultSeatsNumber, childSeatsNumber, hotel);
            return listOfTours.stream()
                    .map(t -> mapper.mapToResponse(t))
                    .toList();
    }



    public ResponseTourDto update(RequestTourDto requestTourDto, Long id){
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no tour with this id"));

        Category categoryExist = categoryRepo.findById(requestTourDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("There is no category with this id"));

        existingTour.setCategory(categoryExist);
        existingTour.setCity(requestTourDto.getCity());
        existingTour.setHotel(requestTourDto.getHotel());
        existingTour.setChildPrice(requestTourDto.getChildPrice());
        existingTour.setAdultPrice(requestTourDto.getAdultPrice());
        existingTour.setAdultSeatsNumber(requestTourDto.getAdultSeatsNumber());
        existingTour.setChildSeatsNumber(requestTourDto.getChildSeatsNumber());
        existingTour.setStartDay(requestTourDto.getStartDay());
        existingTour.setReturnDay(requestTourDto.getReturnDay());

        Tour savedTours = tourRepo.save(existingTour);

        return mapper.mapToResponse(savedTours);


    }



}
