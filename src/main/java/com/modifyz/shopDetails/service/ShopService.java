package com.modifyz.shopDetails.service;

import com.modifyz.shopDetails.domain.Shop;
import com.modifyz.shopDetails.dto.ShopDto;
import java.util.List;
import java.util.Optional;

public interface ShopService {

    Shop createOrUpdate(ShopDto shopDto);

    List<Shop> getAllShops();

    Optional<Shop> getShopById(String shopId);
}
