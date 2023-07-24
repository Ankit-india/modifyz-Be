package com.modifyz.PanelApplicaton.shopDetails.repository;

import com.modifyz.PanelApplicaton.shopDetails.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}