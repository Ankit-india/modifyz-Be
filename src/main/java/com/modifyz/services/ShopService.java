package com.modifyz.services;

import com.modifyz.entities.Shop;
import com.modifyz.dto.ShopDto;
import com.modifyz.dto.ShopInfo;
import java.util.List;
import java.util.Optional;

public interface ShopService {

    Shop createOrUpdate(ShopDto shopDto) throws InterruptedException;

    List<ShopDto> getAllShops();

    Optional<Shop> getShopById(String shopId);

    //List<ShopInfo> getShopInfo();
}
