package com.global.bolgapp.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.bolgapp.model.BlogUser;
import com.global.bolgapp.repository.BlogUserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogUserService {

    private final BlogUserRepo blogUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BlogUser saveNewUser(BlogUser blogUser) {
        System.err.println("New User: " + blogUser);
        blogUser.setPassword(bCryptPasswordEncoder.encode(blogUser.getPassword()));
        return blogUserRepo.saveAndFlush(blogUser);
    }

    public Optional<BlogUser> findByUsername(String usename) {
        return blogUserRepo.findByUsername(usename);
    }

}
