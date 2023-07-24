package com.modifyz.PanelApplicaton.shopDetails.service;

import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;

public interface ShopService {

    Shop createOrUpdate(ShopDto shopDto);
}
