package com.modifyz.PanelApplicaton.shopDetails.service;

import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;
import java.util.List;
import java.util.Optional;

public interface ShopService {

    Shop createOrUpdate(ShopDto shopDto);

    List<Shop> getAllShops();

    Optional<Shop> getShopById(String shopId);
}
