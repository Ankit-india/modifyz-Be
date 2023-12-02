package com.modifyz.convertor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modifyz.dto.ShopDto;
import com.modifyz.entities.Shop;
import com.modifyz.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopConvertor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ContactService contactService;

    public Shop convert(ShopDto shopDto, String contactId, String timeDetailsId) {

        Shop shop = Shop.Builder.shop()
            .withPanNumber(shopDto.getPanNumber())
            .withShopType(shopDto.getShopType())
            .withShopName(shopDto.getShopName())
            .withOwnerName(shopDto.getOwnerName())
            .withDescription(shopDto.getDescription())
            .withContactId(contactId)
            .withTimeDetailsId(timeDetailsId)
            .build();
        return shop;
    }

    //public ShopInfo convertShopInfo(Shop shop) {
    //    //List<String> img = shop.getImages();
    //    Contact contact = contactService.getContactById();
    //    return (
    //        ShopInfo.Builder.shopInfo()
    //            .withId(shop.getId())
    //            .withImg(img.get(0))
    //            .withName(shop.getShopName())
    //            .withAddress(contact.getAddress())
    //            .withDistance(
    //                BigDecimal.ZERO)
    //            .withRating(BigDecimal.ONE)
    //            .build()
    //    );
    //}
}
