package com.modifyz.PanelApplicaton.shopDetails.service.impl;

import com.modifyz.PanelApplicaton.shopDetails.convertor.ShopConvertor;
import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;
import com.modifyz.PanelApplicaton.shopDetails.repository.ShopRepository;
import com.modifyz.PanelApplicaton.shopDetails.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopConvertor shopConvertor;

    @Override
    public Shop createOrUpdate(ShopDto shopDto) {
        Shop shop = shopConvertor.convert(shopDto);
        shopRepository.save(shop);
        return shop;
    }
}
