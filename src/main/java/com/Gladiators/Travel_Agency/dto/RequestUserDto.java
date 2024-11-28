package com.Gladiators.Travel_Agency.dto;

import com.Gladiators.Travel_Agency.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
        private String name;
        private String surname;
        private String email;
        private Integer age;
        private Role role;
    }

