package com.example.demo.booster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoosterRepository extends JpaRepository<Booster, Long> {
    @Query("SELECT b FROM Booster b WHERE b.serialNumber = ?1")
    Optional<Booster> findStudentBySerialNumber(String serialNumber);
}
