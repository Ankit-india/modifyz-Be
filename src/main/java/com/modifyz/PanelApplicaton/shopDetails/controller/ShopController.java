package com.modifyz.PanelApplicaton.shopDetails.controller;

import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import com.modifyz.PanelApplicaton.shopDetails.dto.ShopDto;
import com.modifyz.PanelApplicaton.shopDetails.service.ShopService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/addShop/")
    public ResponseEntity<Shop> addShop(@RequestBody ShopDto shopDto) {
        Shop shop = shopService.createOrUpdate(shopDto);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @GetMapping(value = "/list/shop")
    public ResponseEntity<List<Shop>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<Optional<Shop>> getShopByid(@PathVariable String shopId) {
        return new ResponseEntity<>(shopService.getShopById(shopId), HttpStatus.OK);
    }
}
