package com.example.auth.services.impl;

import com.example.auth.common.dto.TokenResponse;
import com.example.auth.common.dto.UserRequest;
import com.example.auth.repositories.UserRepository;
import com.example.auth.common.entities.UserModel;
import com.example.auth.services.JwtService;
import com.example.auth.services.AuthService;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * AuthServiceImpl.
 */

@Service
public class AuthServiceImpl implements AuthService {
  
  public final UserRepository userRepository;
  public final JwtService jwtService;

  public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
  }

  /**
   * createUser.
   * param userRequest userRequest
   * return TokenResponse
   */
  @Override
  public TokenResponse createUser(UserRequest userRequest) {
    return Optional.of(userRequest)
      .map(this::mapToEntity)
      .map(userRepository::save)
      .map(userCreated -> jwtService.generateToken(userCreated.getId()))
      .orElseThrow(() -> new RuntimeException("Error creating user"));
  }

  private UserModel mapToEntity(UserRequest userRequest) {
    return UserModel.builder()
      .email(userRequest.getEmail())
      .password(userRequest.getPassword())
      .name(userRequest.getName())
      .role("User")
      .build();
  }

}
