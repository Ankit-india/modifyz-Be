package com.modifyz.repositories;

import com.modifyz.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {
}