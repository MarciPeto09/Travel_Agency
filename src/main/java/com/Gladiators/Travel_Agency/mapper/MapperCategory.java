package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestCategoryDto;
import com.Gladiators.Travel_Agency.dto.ResponsTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseCategoryDto;
import com.Gladiators.Travel_Agency.model.Category;
import com.Gladiators.Travel_Agency.model.Tour;

public class MapperCategory {
    public Category mappToEntity(RequestCategoryDto requestCategoryDto) {
        Category categoryEntity = Category.builder()
                .type(requestCategoryDto.getType())

                .build();

        return categoryEntity;}

    public ResponseCategoryDto mapToResponse (Category tour){
        ResponseCategoryDto ResponseCategoryDto = new ResponseCategoryDto();
        responseCategoryDto.setType(tour.getType());

        return ResponseCategoryDto;
}
