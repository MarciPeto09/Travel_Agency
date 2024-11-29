package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestRoleDto;
import com.Gladiators.Travel_Agency.dto.ResponseRoleDto;
import com.Gladiators.Travel_Agency.model.Role;
import org.springframework.stereotype.Component;

@Component
public class MapperRole {

    public Role mapToEntity(RequestRoleDto requestRoleDto){
        return Role.builder()
                .roleType(requestRoleDto.getRoleType())
                .users(requestRoleDto.getUsers())
                .build();
    }

    public ResponseRoleDto mapToResponse (Role role){
        return   ResponseRoleDto.builder()
                .id(role.getId())
                .roleType(role.getRoleType())
                .users(role.getUsers())
                .build();

    }

}
