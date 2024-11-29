package com.Gladiators.Travel_Agency.dto;

import com.Gladiators.Travel_Agency.model.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseUserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String password;
    private List<Role> roles;
}
