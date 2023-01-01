package com.example.jwttutorial.repository;

import com.example.jwttutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") // 쿼리가 수행이 될때 Lazy 조회가 아니고 Eager 조회이다.
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
