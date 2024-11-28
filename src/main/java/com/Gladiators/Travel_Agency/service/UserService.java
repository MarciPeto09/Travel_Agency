package com.Gladiators.Travel_Agency.service;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.mapper.MapperUser;
import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.model.User;
import com.Gladiators.Travel_Agency.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserService {

    UserRepository userRepository;
    MapperUser mapperUser;


    @Autowired
    public UserService(MapperUser mapperUser, UserRepository userRepository) {
        this.mapperUser = mapperUser;
        this.userRepository = userRepository;
    }



    public ResponseUserDto save(RequestUserDto request) {
        User user = mapperUser.mapToEntity(request);
        User savedUser = userRepository.save(user);
        return mapperUser.mapToResponse(savedUser);

    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public ResponseUserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapperUser.mapToResponse(user);
    }



    public List<ResponseUserDto> findAll(){
        List<User> listUser = userRepository.findAll();
        return listUser.stream().map(t -> mapperUser.mapToResponse(t))
                .toList();
    }

}
