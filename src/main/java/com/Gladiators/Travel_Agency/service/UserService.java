package com.Gladiators.Travel_Agency.service;

import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.mapper.MapperUser;
import com.Gladiators.Travel_Agency.model.Users;
import com.Gladiators.Travel_Agency.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

   private final  UserRepository userRepository;
   private final MapperUser mapperUser;
    private final BCryptPasswordEncoder passwordEncoder;



    public ResponseUserDto save(RequestUserDto request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Users user = mapperUser.mapToEntity(request);
        user.setPassword(encodedPassword);
        Users savedUser = userRepository.save(user);
        return mapperUser.mapToResponse(savedUser);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public ResponseUserDto getUserById(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapperUser.mapToResponse(user);
    }



    public List<ResponseUserDto> findAll(){
        List<Users> listUser = userRepository.findAll();
        return listUser.stream().map(t -> mapperUser.mapToResponse(t))
                .toList();
    }


@Transactional
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("Looking for user with username: " + username);
    Users user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
}

}
