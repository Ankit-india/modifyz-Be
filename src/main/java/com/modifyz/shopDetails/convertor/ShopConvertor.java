package com.modifyz.shopDetails.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modifyz.contact.service.ContactService;
import com.modifyz.shopDetails.domain.Shop;
import com.modifyz.shopDetails.dto.ChairInfo;
import com.modifyz.shopDetails.dto.ShopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopConvertor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ContactService contactService;

    public Shop convert(ShopDto shopDto) {
        String chairInfoJson;
        try {
            chairInfoJson = objectMapper.writeValueAsString(
                ChairInfo.Builder.chairInfo().withChairId(shopDto.getChair()).build());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Shop shop = Shop.Builder.shop()
            .withPanNumber(shopDto.getPanNumber())
            .withShopName(shopDto.getShopName())
            .withOwnerName(shopDto.getOwnerName())
            .withNickName(shopDto.getNickName())
            .withDescription(shopDto.getDescription())
            .withImages(null)
            .withChairDetails(chairInfoJson)
            .build();
        return shop;
    }
}
