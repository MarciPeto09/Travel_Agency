package com.Gladiators.Travel_Agency.dto;

import com.Gladiators.Travel_Agency.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRoleDto {
    private String roleType;
    private List<Users> users;
}
