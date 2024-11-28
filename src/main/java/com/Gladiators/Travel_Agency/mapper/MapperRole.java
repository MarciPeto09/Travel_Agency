package com.Gladiators.Travel_Agency.mapper;

import com.Gladiators.Travel_Agency.dto.RequestRoleDto;
import com.Gladiators.Travel_Agency.dto.ResponseRoleDto;
import com.Gladiators.Travel_Agency.model.Role;
import org.springframework.stereotype.Component;

@Component
public class MapperRole {
     public Role mapToEntity(RequestRoleDto requestRoleDto){
         Role roleEntity = Role.builder()
                 .roleType(requestRoleDto.getRoleType())
                 .build();
         return roleEntity;
     }

     public ResponseRoleDto mapToResponse (Role role){
         ResponseRoleDto responseRoleDto = new ResponseRoleDto();
         responseRoleDto.setId(role.getId());
         responseRoleDto.setRoleType(role.getRoleType());

         return responseRoleDto ;
     }

}
