package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.model.User;
import org.springframework.stereotype.Component;


@Component
public class MapperUser {

    public User mapToEntity(RequestUserDto requestUserDto) {
        User userEntity = User.builder()
                .name(requestUserDto.getName())
                .surname(requestUserDto.getSurname())
                .email(requestUserDto.getEmail())
                .age(requestUserDto.getAge())
                .role(requestUserDto.getRole())
                .build();

                return userEntity;
    }



    public ResponseUserDto mapToResponse (User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setName(user.getName());
        responseUserDto.setSurname(user.getSurname());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setAge(user.getAge());
        responseUserDto.setRole(user.getRole());

        return responseUserDto;
    }
}
