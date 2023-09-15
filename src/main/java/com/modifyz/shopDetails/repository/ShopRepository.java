package com.modifyz.shopDetails.repository;

import com.modifyz.shopDetails.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {
}