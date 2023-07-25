package com.modifyz.PanelApplicaton.facilityDetails.repository;

import com.modifyz.PanelApplicaton.facilityDetails.domain.Facility;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query(value = "SELECT * FROM facility WHERE is_deleted = false AND shop_id = ?1", nativeQuery = true)
    List<Facility> findFacilityByShopId(String shopId);

    @Query(value = "SELECT * FROM facility WHERE is_deleted = false AND shop_id = ?1 AND service_name = ?2", nativeQuery = true)
    Facility getFacilityByShopIdAndServiceName(String shopId, String facilityName);
}
