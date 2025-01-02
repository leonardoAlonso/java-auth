package com.example.auth.common.dto;

import lombok.*;

/**
 * TokenResponse.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponse {
  
  private String accessToken;


}
