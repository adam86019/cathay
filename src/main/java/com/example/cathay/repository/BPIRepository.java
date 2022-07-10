package com.example.cathay.repository;

import com.example.cathay.entity.BPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BPIRepository extends JpaRepository<BPI, String>, JpaSpecificationExecutor<BPI> {

    BPI findByCode(String code);
}
