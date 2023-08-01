package com.modifyz.PanelApplicaton.shopDetails.service.impl;

import com.modifyz.PanelApplicaton.contact.service.ContactService;
import com.modifyz.PanelApplicaton.shopDetails.convertor.ShopConvertor;
import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;
import com.modifyz.PanelApplicaton.shopDetails.repository.ShopRepository;
import com.modifyz.PanelApplicaton.shopDetails.service.ShopService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopConvertor shopConvertor;

    @Autowired
    private ContactService contactService;

    @Override
    public Shop createOrUpdate(ShopDto shopDto) {

        Shop shop = shopConvertor.convert(shopDto);
        shopRepository.save(shop);
        return shop;
    }

    @Override
    public List<Shop> getAllShops() {
        List<Shop> shopList = shopRepository.findAll();
        return shopList;
    }

    @Override
    public Optional<Shop> getShopById(String shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        return shop;
    }
}
