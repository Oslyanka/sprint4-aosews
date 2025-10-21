package com.xp.advisor.service.impl;

import com.xp.advisor.entity.Asset;
import com.xp.advisor.repository.AssetRepository;
import com.xp.advisor.service.AssetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
  private final AssetRepository repo;
  public AssetServiceImpl(AssetRepository repo){ this.repo = repo; }
  public Asset create(Asset a){ return repo.save(a); }
  public List<Asset> list(){ return repo.findAll(); }
}
