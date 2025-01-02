package com.example.auth.controllers.impl;

import com.example.auth.controllers.AuthApi;
import com.example.auth.common.dto.TokenResponse;
import com.example.auth.common.dto.UserRequest;
import com.example.auth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController.
 */
@RestController
public class AuthController implements AuthApi {
  private final AuthService authService;

  /**
   * AuthController.
   * 
   * @param authService authService
   */
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  /**
   * createUser.
   * 
   * @param userRequest userRequest
   * @return ResponseEntity<TokenResponse>
   */
  @Override
  public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
    return ResponseEntity.ok(authService.createUser(userRequest));
  }
}
