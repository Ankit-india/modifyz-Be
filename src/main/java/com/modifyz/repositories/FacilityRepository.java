package com.modifyz.repositories;

import com.modifyz.entities.Facility;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, String> {

    @Query(value = "SELECT * FROM facility WHERE isDeleted = false AND shopId = ?1", nativeQuery = true)
    List<Facility> findFacilityByShopId(String shopId);

    @Query(value = "SELECT * FROM facility WHERE isDeleted = false AND shopId = ?1 AND serviceName = ?2", nativeQuery = true)
    Facility getFacilityByShopIdAndServiceName(String shopId, String facilityName);

    @Query(value = "SELECT * FROM facility WHERE isDeleted = false AND shopId = ?1 AND id = ?2", nativeQuery = true)
    Facility findByShopIdAndFacilityId(String shopId, String facilityId);
}
