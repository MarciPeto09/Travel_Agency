package com.Gladiators.Travel_Agency.dto;

import com.Gladiators.Travel_Agency.model.Users;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRoleDto {
    private Long id;
    private String roleType;
    private List<Users> users;
}
