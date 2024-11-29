package com.Gladiators.Travel_Agency.controller;

import com.Gladiators.Travel_Agency.dto.RequestRoleDto;
import com.Gladiators.Travel_Agency.dto.RequestUserDto;
import com.Gladiators.Travel_Agency.dto.ResponseRoleDto;
import com.Gladiators.Travel_Agency.dto.ResponseUserDto;
import com.Gladiators.Travel_Agency.service.RoleService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequestMapping("api/role")
@NoArgsConstructor
@Controller
public class RoleController {

    private RoleService roleService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseRoleDto>> findAll(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseRoleDto> save(@RequestBody RequestRoleDto requestRoleDto){
        return new ResponseEntity<>(roleService.save(requestRoleDto), HttpStatus.CREATED);
    }

}
