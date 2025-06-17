package com.example.bookapi.controller;

import com.example.bookapi.model.User;
import com.example.bookapi.security.JwtUtil;
import com.example.bookapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final JwtUtil jwtUtil;
  private final UserService userService;

  public AuthController(JwtUtil jwtUtil, UserService userService) {
    this.jwtUtil = jwtUtil;
    this.userService = userService;
  }



  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    String username = request.get("username");
    String password = request.get("password");


    return userService.authenticate(username, password)
      .map(user -> Map.of("token", jwtUtil.generateToken(user.getUsername(),user.getRole() )))
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
    String username = request.get("username");
    String password = request.get("password");
    String role = request.getOrDefault("role", "ROLE_USER");
    User user = userService.register(username, password, role);
    return ResponseEntity.ok(Map.of("id", user.getId(), "username", user.getUsername()));
  }

  @GetMapping("/debug")
  public ResponseEntity<String> debugAuth() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("👤 Authentication: " + auth);
    System.out.println("🔐 Authorities: " + auth.getAuthorities());
    return ResponseEntity.ok("Hello " + auth.getName());
  }


}
