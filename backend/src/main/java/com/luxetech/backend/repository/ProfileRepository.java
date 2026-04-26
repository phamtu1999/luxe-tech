package com.luxetech.backend.repository;

import com.luxetech.backend.entity.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    // Basic CRUD provided by JpaRepository
}
