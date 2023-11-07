package com.modifyz.shopDetails.controller;

import com.modifyz.shopDetails.domain.Shop;
import com.modifyz.shopDetails.dto.ShopDto;
import com.modifyz.shopDetails.dto.ShopInfo;
import com.modifyz.shopDetails.service.ShopService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

    private Logger logger = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/addShop")
    public ResponseEntity<Shop> addShop(@RequestBody ShopDto shopDto) {
        Shop shop = shopService.createOrUpdate(shopDto);
        //logger.info("{} images has been uploaded", images.length);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @PostMapping(value = "/uploadImages")
    public ResponseEntity<?> uplaod(@RequestParam("images") MultipartFile[] files) {
        logger.info("{} files uploaded", files.length);
        return new ResponseEntity<>("fileUploaded Successfully", HttpStatus.OK);
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<Shop>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<Optional<Shop>> getShopByid(@PathVariable String shopId) {
        return new ResponseEntity<>(shopService.getShopById(shopId), HttpStatus.OK);
    }

    @GetMapping(value = "/shopInfo")
    public  ResponseEntity<List<ShopInfo>> getShopInfo() {
        return new ResponseEntity<>(shopService.getShopInfo(), HttpStatus.OK);
    }
}