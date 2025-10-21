package com.xp.advisor.controller;

import com.xp.advisor.entity.Asset;
import com.xp.advisor.service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
  private final AssetService service;
  public AssetController(AssetService service){ this.service = service; }

  @PostMapping
  public ResponseEntity<Asset> create(@RequestBody Asset a){
    return ResponseEntity.ok(service.create(a));
  }

  @GetMapping
  public ResponseEntity<List<Asset>> list(){
    return ResponseEntity.ok(service.list());
  }
}
