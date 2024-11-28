package com.Gladiators.Travel_Agency.service;

import com.Gladiators.Travel_Agency.dto.RequestReviewDto;
import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseReviewDto;
import com.Gladiators.Travel_Agency.mapper.MapperReview;
import com.Gladiators.Travel_Agency.mapper.MapperTour;
import com.Gladiators.Travel_Agency.model.Review;

import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.repository.ReviewRepo;
import com.Gladiators.Travel_Agency.repository.TourRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ReviewService {

        private ReviewRepo reviewRepoRepo;
        private MapperReview mapper;
        private TourRepository tourRepository;


        public List<ResponseReviewDto> findAll(){
            List<Review> listTour = reviewRepoRepo.findAll();
            return listTour.stream()
                    .map(r -> mapper.mapToRespons(r))
                    .toList();
        }


       public ResponseReviewDto getById(Long id) {
           Review review = reviewRepoRepo.findById(id)
                   .orElseThrow(() -> new RuntimeException("There is no review with this id"));
           return mapper.mapToRespons(review);
       }

    public void deleteReviewById(Long id){
        Review existingReview = reviewRepoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("This review id does not exist!"));

        if(existingReview != null){
            reviewRepoRepo.delete(existingReview);
        }else{
            throw new RuntimeException("This tour id does not exist!");
        }
    }


    public  ResponseReviewDto save(RequestReviewDto requestReviewDto) {

            //convertin the filds from a review dto to a review entity
            Review review = mapper.mapToEntity(requestReviewDto);
            //am searching for a tour on DB based on the id procided on requestDto
            Tour tour = tourRepository.findById(requestReviewDto.getTourId())
                    .orElseThrow(() -> new RuntimeException("This tour id does not exist!"));

            //Setting the tour to the review entity
            review.setTour(tour);

            //Saving the review entity on the Db
            Review savedReview = reviewRepoRepo.save(review);

            //mapping entity to responseDto and returning the final responseDto
             return  mapper.mapToRespons(savedReview);
    }



}
