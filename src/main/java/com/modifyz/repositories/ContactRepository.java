package com.modifyz.repositories;

import com.modifyz.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, String> {

    @Query(value = "SELECT * FROM contact WHERE id = ?1", nativeQuery = true)
    Contact getContactById(String id);
}
