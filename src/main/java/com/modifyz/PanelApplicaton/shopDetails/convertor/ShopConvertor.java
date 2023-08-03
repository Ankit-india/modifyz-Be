package com.modifyz.PanelApplicaton.shopDetails.convertor;

import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;
import org.springframework.stereotype.Component;

@Component
public class ShopConvertor {

    public Shop convert(ShopDto shopDto) {
        Shop shop = Shop.Builder.shop()
            .withpanNumber(shopDto.getPanNumber())
            .withShopName(shopDto.getShopName())
            .withOwnerName(shopDto.getOwnerName())
            .withNickName(shopDto.getNickName())
            .withDescription(shopDto.getDescription())
            .withImages(shopDto.getImages())
            .build();
        return shop;
    }
}
