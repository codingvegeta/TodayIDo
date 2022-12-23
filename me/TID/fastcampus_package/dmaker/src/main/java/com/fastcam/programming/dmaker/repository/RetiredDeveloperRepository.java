package com.fastcam.programming.dmaker.repository;

import com.fastcam.programming.dmaker.entity.Developer;
import com.fastcam.programming.dmaker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {
}

