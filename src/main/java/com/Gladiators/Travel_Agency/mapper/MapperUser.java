package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.model.Users;
import org.springframework.stereotype.Component;


@Component
public class MapperUser {

    public Users mapToEntity(RequestUserDto requestUserDto) {
        return  Users.builder()
                .username(requestUserDto.getUsername())
                .surname(requestUserDto.getSurname())
                .email(requestUserDto.getEmail())
                .password(requestUserDto.getPassword())
                .age(requestUserDto.getAge())
                .roles(requestUserDto.getRoles())
                .build();
    }



    public ResponseUserDto mapToResponse (Users user) {

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
