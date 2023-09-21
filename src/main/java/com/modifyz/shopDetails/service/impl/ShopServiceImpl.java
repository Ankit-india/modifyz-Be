package com.modifyz.shopDetails.service.impl;

import com.modifyz.contact.dto.ContactDto;
import com.modifyz.contact.service.ContactService;
import com.modifyz.shopDetails.convertor.ShopConvertor;
import com.modifyz.shopDetails.domain.Shop;
import com.modifyz.shopDetails.dto.ShopDto;
import com.modifyz.shopDetails.repository.ShopRepository;
import com.modifyz.shopDetails.service.ShopService;
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
        contactService.createOrUpdateContact(ContactDto.Builder.contactDto()
            .withShopId(shop.getId())
            .withMobileNumber(shopDto.getMobileNumber())
            .withAlternateMobileNumber(shopDto.getAlternateMobileNumber())
            .withAddress(shopDto.getAddress())
            .build()
        ).getId();
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
