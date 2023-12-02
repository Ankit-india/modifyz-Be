package com.modifyz.controller;

import com.modifyz.commons.common.CommonServices.FileService;
import com.modifyz.dto.ShopDto;
import com.modifyz.entities.Shop;
import com.modifyz.services.ShopService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
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

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/addShop")
    public ResponseEntity<Shop> addShop(@RequestBody ShopDto shopDto)
        throws InterruptedException {
        Shop shop = shopService.createOrUpdate(shopDto);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }


    @GetMapping(value = "/list")
    public ResponseEntity<List<ShopDto>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<Optional<Shop>> getShopById(@PathVariable String shopId) {
        return new ResponseEntity<>(shopService.getShopById(shopId), HttpStatus.OK);
    }

    @PostMapping(value = "/uploadImages")
    public ResponseEntity<?> uplaod(@RequestParam("images") MultipartFile[] imagesList) throws
        IOException {
        String dirName = fileService.uploadImages(imagesList);
        logger.info("{} files uploaded", imagesList.length);
        return new ResponseEntity<>("file Uploaded Successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/{folderName}/{imageName}")
    public void getImages(
        @PathVariable("folderName") String folderName,
        @PathVariable("imageName") String imageName,
        HttpServletResponse response) throws IOException {
        InputStream resource = fileService.getResources(folderName, imageName);
        response.setContentType("");
        StreamUtils.copy(resource, response.getOutputStream());
    }

    //@GetMapping(value = "/shopInfo")
    //public  ResponseEntity<List<ShopInfo>> getShopInfo() {
    //    return new ResponseEntity<>(shopService.getShopInfo(), HttpStatus.OK);
    //}
}