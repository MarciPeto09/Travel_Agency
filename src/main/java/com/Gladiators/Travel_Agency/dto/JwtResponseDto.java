package com.Gladiators.Travel_Agency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class JwtResponseDto {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private List<String> roles;

  public JwtResponseDto(String jwt, Long id, String username, String email, List<String> roles) {
  }
}