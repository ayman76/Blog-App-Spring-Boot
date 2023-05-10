package com.global.bolgapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.bolgapp.model.BlogUser;

public interface BlogUserRepo extends JpaRepository<BlogUser, Long> {
    
    Optional<BlogUser> findByUsername(String username);
}
