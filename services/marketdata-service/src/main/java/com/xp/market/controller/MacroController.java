package com.xp.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class MacroController {
  @GetMapping("/api/macros")
  public Map<String, BigDecimal> macros() {
    return Map.of(
      "selic", new BigDecimal("0.1275"),
      "inflation", new BigDecimal("0.0430"),
      "usdbrl", new BigDecimal("5.45")
    );
  }
}
