package com.modifyz.services;

import com.modifyz.dto.InventoryDto;

public interface InventoryService {
    String addInventory(InventoryDto inventoryDto) throws InterruptedException;
    String updateInventory(String shopId, InventoryDto inventoryDto);
}
