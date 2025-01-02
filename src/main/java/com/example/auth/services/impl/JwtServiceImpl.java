package com.example.auth.services.impl;

import java.util.Date;

import com.example.auth.common.dto.TokenResponse;
import com.example.auth.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * JwtServiceImpl.
 */
@Service
public class JwtServiceImpl implements JwtService {

  public final String secretToken;

  public JwtServiceImpl(@Value("${jwt.secret}") String secretToken) {
    this.secretToken = secretToken;
  }

  /**
  * generateToken.
  * param userId userId
  * return TokenResponse
  */
  @Override
  public TokenResponse generateToken(Long userId) {
    Date expirationDate = new Date(Long.MAX_VALUE);
    String token = Jwts.builder()
        .setSubject(String.valueOf(userId))
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS512, secretToken)
        .compact();
    return TokenResponse.builder()
      .accessToken(token)
      .build();
  }

  /**
  * getClaims.
  * param token token
  * return Claims
  */
  @Override
  public Claims getClaims(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(secretToken)
      .build()
      .parseClaimsJws(token)
      .getBody();
  }

  /**
  * isExpired.
  * param token token
  * return boolean
  */
  @Override
  public boolean isExpired(String token) {
    try {
      return getClaims(token).getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  /**
  * extractUserId.
  * param token token
  * return Integer
  */
  @Override
  public Integer extractUserId(String token) {
    try {
      return Integer.parseInt(getClaims(token).getSubject());
    } catch (Exception e) {
      //TODO: handle exception
      return null;
    }
  }
}
