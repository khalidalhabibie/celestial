package com.example.bookapi.service;



import com.example.bookapi.model.User;
import com.example.bookapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.encoder = new BCryptPasswordEncoder();
  }

  public User register(String username, String rawPassword) {
    if (userRepository.findByUsername(username).isPresent()) {
      throw new RuntimeException("Username already exists");
    }
    return userRepository.save(
      User.builder()
        .username(username)
        .password(encoder.encode(rawPassword))
        .build()
    );
  }

  public Optional<User> authenticate(String username, String password) {
    return userRepository.findByUsername(username)
      .filter(user -> encoder.matches(password, user.getPassword()));
  }

  public User register(String username, String rawPassword, String role) {
    if (userRepository.findByUsername(username).isPresent()) {
      throw new RuntimeException("Username already exists");
    }
    return userRepository.save(
      User.builder()
        .username(username)
        .password(encoder.encode(rawPassword))
        .role(role)
        .build()
    );
  }

}
