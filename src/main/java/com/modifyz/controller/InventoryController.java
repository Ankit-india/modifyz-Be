package com.modifyz.controller;

import com.modifyz.dto.InventoryDto;
import com.modifyz.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired InventoryService inventoryService;
    @PostMapping("/{shopId}/")
    public ResponseEntity<?> updateInventory(@PathVariable("shopId") String shopId, InventoryDto inventoryDto) {
        inventoryService.updateInventory(shopId, inventoryDto);
        return ResponseEntity.ok("successfully Updated");
    }
}
