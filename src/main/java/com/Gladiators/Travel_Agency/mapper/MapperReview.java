package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestReviewDto;
import com.Gladiators.Travel_Agency.dto.ResponseReviewDto;
import com.Gladiators.Travel_Agency.model.Review;
import org.springframework.stereotype.Component;

@Component
public class MapperReview {

    public Review mapToEntity(RequestReviewDto requestReviewDto){
        Review review = new Review();
        review.setDescription(requestReviewDto.getDescription());
        review.setData(requestReviewDto.getData());
        review.setNumber(requestReviewDto.getNumber());

        return review;
    }


    public ResponseReviewDto mapToRespons(Review review) {
        ResponseReviewDto responseReviewDto = new ResponseReviewDto();

        responseReviewDto.setData(review.getData());
        responseReviewDto.setId(review.getId());
        responseReviewDto.setDescription(review.getDescription());
        responseReviewDto.setNumber(review.getNumber());
        responseReviewDto.setTourId(review.getTour().getId());

        return responseReviewDto;
    }
}
