package com.modifyz.services.impl;

import com.modifyz.constant.Meridiem;
import com.modifyz.convertor.InventoryConvertor;
import com.modifyz.dto.InventoryDto;
import com.modifyz.dto.TimeDetailsDto;
import com.modifyz.entities.Inventory;
import com.modifyz.repositories.InventoryRepository;
import com.modifyz.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class InventoryServiceImpl implements InventoryService {

    @Autowired InventoryConvertor inventoryConvertor;

    @Autowired InventoryRepository inventoryRepository;

    @Override
    public String addInventory(InventoryDto inventoryDto) throws InterruptedException {
        TimeDetailsDto timeDetailsDto = inventoryDto.getTimeDetailsDto();
        int hh = timeDetailsDto.getEndTime().getHours() - timeDetailsDto.getStartTime().getHours();
        if (timeDetailsDto.getEndTime().getMeridiem().equals(Meridiem.PM.toString())) {
            hh += 12;
        }
        int mm =
            timeDetailsDto.getEndTime().getMinutes() - timeDetailsDto.getStartTime().getMinutes();
        int hours = hh * 12;
        int minutes = mm / 5;
        int lengthOfAvailabilityArray = hours + minutes;
        StringBuffer availability = new StringBuffer();
        for (int i = 0; i < lengthOfAvailabilityArray; i++) {
            availability.append(0);
        }
        for (int i = 1; i <= inventoryDto.getNumberOfChairs(); i++) {
            Inventory inventory = inventoryConvertor.convert(inventoryDto, i,availability.toString());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                throw new InterruptedException(e.getMessage());
            }
            inventoryRepository.save(inventory);
            System.out.println(inventory.getId());
        }
        return "Successfully added Inventory";
    }

    @Override public String updateInventory(String shopId, InventoryDto inventoryDto) {
        return null;
    }
}
