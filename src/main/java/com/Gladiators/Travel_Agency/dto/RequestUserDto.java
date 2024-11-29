package com.Gladiators.Travel_Agency.dto;

import com.Gladiators.Travel_Agency.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
        private String name;
        private String surname;
        private String email;
        private Integer age;
        private String password;
        private List<Role> roles;
    }

