package com.example.bookapi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

  private final String secret = "secret-key-1234567890abcdefghijk"; // 32 chars min for HS256

  public String generateToken(String username, String role) {
    return Jwts.builder()
      .setSubject(username)
      .claim("role", role)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 3600000))
      .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
      .compact();
  }

  public String extractRole(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
      .build()
      .parseClaimsJws(token)
      .getBody()
      .get("role", String.class);
  }


  public String extractUsername(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
      .build()
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
        .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
        .build()
        .parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }
}
