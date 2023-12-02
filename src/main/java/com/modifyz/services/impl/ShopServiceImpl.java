package com.modifyz.services.impl;

import com.modifyz.convertor.InventoryConvertor;
import com.modifyz.convertor.ShopConvertor;
import com.modifyz.dto.InventoryDto;
import com.modifyz.dto.ShopDto;
import com.modifyz.entities.Contact;
import com.modifyz.entities.Shop;
import com.modifyz.entities.TimeDetails;
import com.modifyz.repositories.ShopRepository;
import com.modifyz.services.ContactService;
import com.modifyz.services.InventoryService;
import com.modifyz.services.ShopService;
import com.modifyz.services.TimeDetailsService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopConvertor shopConvertor;

    @Autowired
    private ContactService contactService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TimeDetailsService timeDetailsService;

    @Autowired
    private InventoryConvertor inventoryConvertor;
    @Override
    public Shop createOrUpdate(ShopDto shopDto) throws InterruptedException {
        Contact contact = contactService.createOrUpdateContact(shopDto.getContactDto());

        TimeDetails timeDetails = timeDetailsService.addTimeDetails(shopDto.getTimeDetailsDto());

        Shop shop = shopConvertor.convert(shopDto, contact.getId(), timeDetails.getId());

        shop = shopRepository.save(shop);

        InventoryDto inventoryDto =
            inventoryConvertor.convertToDto(shop.getId(), shopDto.getNumberOfChairs(),
                shopDto.getTimeDetailsDto());
        inventoryService.addInventory(inventoryDto);
        return shop;
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<Shop> shopList = shopRepository.findAll();
        List<ShopDto> shopDtoList = new ArrayList<>();
        for (Shop shop : shopList) {
            contactService.getContactById(shop.getContactId());
        }
        return shopDtoList;
    }

    @Override
    public Optional<Shop> getShopById(String shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        return shop;
    }

    //@Override
    //public List<ShopInfo> getShopInfo() {
    //    List<Shop> allShopList = shopRepository.findAll();
    //    List<ShopInfo> shopInfoList = new ArrayList<>();
    //    for(Shop shop: allShopList) {
    //        ShopInfo shopInfo = shopConvertor.convertShopInfo(shop);
    //        shopInfoList.add(shopInfo);
    //    }
    //    return shopInfoList;
    //}
}
