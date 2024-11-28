package com.Gladiators.Travel_Agency.service;


import com.Gladiators.Travel_Agency.dto.RequestRoleDto;
import com.Gladiators.Travel_Agency.dto.ResponseRoleDto;
import com.Gladiators.Travel_Agency.mapper.MapperRole;
import com.Gladiators.Travel_Agency.model.Role;
import com.Gladiators.Travel_Agency.repository.RoleRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class RoleService {

    RoleRepository roleRepository;
    MapperRole mapperRole;

    public RoleService(MapperRole mapperRole, RoleRepository roleRepository) {
        this.mapperRole = mapperRole;
        this.roleRepository = roleRepository;
    }



    public ResponseRoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return mapperRole.mapToResponse(role);
    }


    public List<ResponseRoleDto> findAll(){
        List<Role> listRole = roleRepository.findAll();
        return listRole.stream().map(t -> mapperRole.mapToResponse(t))
                .toList();
    }


    public ResponseRoleDto save(RequestRoleDto request) {
        Role role = mapperRole.mapToEntity(request);
        Role savedRole = roleRepository.save(role);
        return mapperRole.mapToResponse(savedRole);

    }


    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }






}
