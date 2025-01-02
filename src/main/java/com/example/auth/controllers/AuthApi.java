package com.example.auth.controllers;

import com.example.auth.common.constants.ApiPathConstants;
import com.example.auth.common.dto.TokenResponse;
import com.example.auth.common.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthApi.
 */
@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
  
  /**
   * createUser.
   * 
   * @param userRequest userRequest
   * @return ResponseEntity<TokenResponse>
   */
  @PostMapping
  ResponseEntity<TokenResponse> createUser(@Valid @RequestBody UserRequest userRequest);
   
}
