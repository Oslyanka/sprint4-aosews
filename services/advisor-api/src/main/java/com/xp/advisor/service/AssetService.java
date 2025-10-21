package com.xp.advisor.service;

import com.xp.advisor.entity.Asset;
import java.util.List;

public interface AssetService {
  Asset create(Asset a);
  List<Asset> list();
}
