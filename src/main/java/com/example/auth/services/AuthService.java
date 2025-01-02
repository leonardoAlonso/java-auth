package com.example.auth.services;

import com.example.auth.common.dto.TokenResponse;
import com.example.auth.common.dto.UserRequest;

/**
 * AuthService.
 */
public interface AuthService {
  
  /**
   * createUser.
   * param userRequest userRequest
   * return TokenResponse
   */
  TokenResponse createUser(UserRequest userRequest);
  
}
