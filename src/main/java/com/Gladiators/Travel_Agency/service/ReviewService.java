package com.Gladiators.Travel_Agency.service;

import com.Gladiators.Travel_Agency.dto.RequestReviewDto;
import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseReviewDto;
import com.Gladiators.Travel_Agency.dto.ResponsTourDto;
import com.Gladiators.Travel_Agency.mapper.MapperReview;
import com.Gladiators.Travel_Agency.mapper.MapperTour;
import com.Gladiators.Travel_Agency.model.Review;

import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.repository.ReviewRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;


@Service
@NoArgsConstructor
@RequiredArgsConstructor
public class ReviewService {

        private ReviewRepo reviewRepoRepo;
        private MapperReview mapper;


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
            Review review = mapper.mapToEntity(requestReviewDto);
             reviewRepoRepo.save(review);
             return  mapper.mapToRespons(review);
    }



}
