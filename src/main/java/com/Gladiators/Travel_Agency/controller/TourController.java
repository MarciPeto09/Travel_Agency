package com.Gladiators.Travel_Agency.controller;

import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponsTourDto;
import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.service.TourService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/tour")
public class TourController {

    private TourService tourService;


    @PostMapping("/save")
    public ResponseEntity<ResponsTourDto> save(@RequestBody RequestTourDto requestTourDto){
        return new ResponseEntity<>(tourService.save(requestTourDto),HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<ResponsTourDto>> findAll(){
        return ResponseEntity.ok(tourService.findAll());



    }

}



