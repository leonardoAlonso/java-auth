package com.example.auth.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * UserRequest.
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  @NotNull
  private String email;
  @NotNull
  private String password;
  @NotNull
  private String name;
}
