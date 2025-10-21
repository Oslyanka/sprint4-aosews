package com.xp.advisor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
  private final WebClient market;

  public RecommendationController(WebClient market){
    this.market = market;
  }

  @PostMapping("/generate")
  public ResponseEntity<?> generate(@RequestBody Map<String,Object> body){
    Map macros = market.get().uri("/api/macros").retrieve().bodyToMono(Map.class).block();
    return ResponseEntity.ok(Map.of(
      "explanation","Carteira simulada baseada nas macros: " + macros,
      "positions", new String[]{"TESOURO:60%","IVVB11:40%"}
    ));
  }
}
