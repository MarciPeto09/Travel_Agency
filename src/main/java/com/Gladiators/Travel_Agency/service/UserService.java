package com.Gladiators.Travel_Agency.service;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseTourDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.mapper.MapperUser;
import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.model.User;
import com.Gladiators.Travel_Agency.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

   private  UserRepository userRepository;
   private MapperUser mapperUser;



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


@Transactional
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("Looking for user with username: " + username);
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
}

}
