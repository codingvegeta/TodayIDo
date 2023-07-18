package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.AccessIp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {
    AccessIp findByIpAddress(String IpAddress);

}
