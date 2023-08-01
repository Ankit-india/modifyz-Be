package com.modifyz.PanelApplicaton.contact.repository;

import com.modifyz.PanelApplicaton.contact.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, String> {

    @Query(value = "SELECT * FROM contact WHERE shop_id = ?1", nativeQuery = true)
    Contact getContactByShopId(String shopId);
}
