package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.model.User;
import org.springframework.stereotype.Component;


@Component
public class MapperUser {

    public User mapToEntity(RequestUserDto requestUserDto) {
        return  User.builder()
                .username(requestUserDto.getName())
                .surname(requestUserDto.getSurname())
                .email(requestUserDto.getEmail())
                .password(requestUserDto.getPassword())
                .age(requestUserDto.getAge())
                .roles(requestUserDto.getRoles())
                .build();
    }



    public ResponseUserDto mapToResponse (User user) {

        return ResponseUserDto.builder()
                .id(user.getId())
                .name(user.getUsername())
                .roles(user.getRoles())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .surname(user.getSurname())
                .build();

    }
}
