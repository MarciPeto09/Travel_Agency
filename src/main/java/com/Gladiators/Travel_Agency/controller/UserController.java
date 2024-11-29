package com.Gladiators.Travel_Agency.controller;

import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ResponseBody
@RequestMapping("api/user")
@NoArgsConstructor
@Controller
public class UserController {
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseUserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseUserDto> save(@RequestBody RequestUserDto requestUserDto){
        return new ResponseEntity<>(userService.save(requestUserDto), HttpStatus.CREATED);
    }
}
