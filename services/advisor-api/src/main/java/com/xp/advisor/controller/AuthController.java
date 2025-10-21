package com.xp.advisor.controller;

import com.xp.advisor.dto.LoginRequest;
import com.xp.advisor.dto.RegisterRequest;
import com.xp.advisor.dto.TokenResponse;
import com.xp.advisor.entity.UserAccount;
import com.xp.advisor.repository.UserRepository;
import com.xp.advisor.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserRepository users;
  private final PasswordEncoder encoder;
  private final JwtUtil jwt;

  public AuthController(UserRepository users, PasswordEncoder encoder) {
    this.users = users;
    this.encoder = encoder;
    this.jwt = new JwtUtil("change-me-please-256bits-change-me-please", 3600);
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
    if (users.findByEmail(req.email()).isPresent()) {
      return ResponseEntity.status(409).body("Email already registered");
    }
    UserAccount ua = new UserAccount();
    ua.setName(req.name());
    ua.setEmail(req.email());
    ua.setPasswordHash(encoder.encode(req.password()));
    users.save(ua);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
    Optional<UserAccount> opt = users.findByEmail(req.email());
    if (opt.isEmpty()) return ResponseEntity.status(401).body("Invalid credentials");
    UserAccount u = opt.get();
    if (!encoder.matches(req.password(), u.getPasswordHash())) {
      return ResponseEntity.status(401).body("Invalid credentials");
    }
    String token = jwt.generateToken(u.getEmail());
    return ResponseEntity.ok(new TokenResponse(token, 3600));
  }
}
