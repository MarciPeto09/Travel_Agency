package com.Gladiators.Travel_Agency.controller;

import com.Gladiators.Travel_Agency.dto.RequestReviewDto;
import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseReviewDto;
import com.Gladiators.Travel_Agency.service.ReviewService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<ResponseReviewDto> save(@RequestBody RequestTourDto requestTourDto){
        return new ResponseEntity<>(reviewService.save(new RequestReviewDto()), HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseReviewDto>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());


    }


}
