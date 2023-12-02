package com.modifyz.repositories;

import com.modifyz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM user WHERE isDeleted = false AND phoneNumber = ?1", nativeQuery = true)
    User findByPhoneNumber(String phoneNumber);
}
