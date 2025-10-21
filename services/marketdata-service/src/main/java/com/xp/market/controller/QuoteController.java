package com.xp.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class QuoteController {
  @GetMapping("/api/quotes")
  public Map<String, BigDecimal> quotes(@RequestParam(defaultValue = "XPBR31") List<String> tickers) {
    Map<String, BigDecimal> out = new LinkedHashMap<>();
    for (String t : tickers) {
      out.put(t.toUpperCase(), new BigDecimal("100.00"));
    }
    return out;
  }
}
