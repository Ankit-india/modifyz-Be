package com.modifyz.convertor;

import com.modifyz.dto.InventoryDto;
import com.modifyz.dto.TimeDetailsDto;
import com.modifyz.entities.Inventory;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InventoryConvertor {

    public Inventory convert(InventoryDto inventoryDto, int i, String availability) {
        return Inventory.Builder.inventory()
            .withShopId(inventoryDto.getShopId())
            .withChairId(i)
            .withAvailability(availability)
            .build();
    }

    public InventoryDto convertToDto(String shopId, int numberOfChairs, TimeDetailsDto timeDetailsDto) {
        return InventoryDto.Builder.inventoryDto()
            .withShopId(shopId)
            .withNumberOfChairs(numberOfChairs)
            .withTimeDetailsDto(timeDetailsDto)
            .build();
    }

}
