package com.Gladiators.Travel_Agency.controller;

import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/tour")
public class TourController {

    private TourService tourService;


    @PostMapping("/save")
    public ResponseEntity<ResponseTourDto> save(@RequestBody RequestTourDto requestTourDto){
        return new ResponseEntity<>(tourService.save(requestTourDto),HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseTourDto>> findAll(){
        return ResponseEntity.ok(tourService.findAll());
    }


    @GetMapping("/all")
    public ResponseEntity<List<ResponseTourDto>> findByCityAndStartDayAndReturnDayAndAdultPriceAndChildPriceAndAdultSeatsNumberAndChildSeatsNumberAndHotel(@RequestParam(required = false)  String city,  @RequestParam(required = false) Double adultPrice, @RequestParam(required = false) Double childPrice, @RequestParam(required = false) Integer adultSeatsNumber, @RequestParam(required = false)Integer childSeatsNumber, @RequestParam(required = false)String hotel) {
        return ResponseEntity.ok(tourService.findByCityAndStartDayAndReturnDayAndAdultPriceAndChildPriceAndAdultSeatsNumberAndChildSeatsNumberAndHotel(city,  adultPrice, childPrice, adultSeatsNumber, childSeatsNumber, hotel));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseTourDto> update(@RequestBody RequestTourDto requestTourDto, @PathVariable Long id){
        return ResponseEntity.ok(tourService.update(requestTourDto, id));
    }
}



