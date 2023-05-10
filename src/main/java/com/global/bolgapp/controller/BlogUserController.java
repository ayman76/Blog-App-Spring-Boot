package com.global.bolgapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.bolgapp.error.DuplicateUsernameException;
import com.global.bolgapp.model.BlogUser;
import com.global.bolgapp.service.BlogUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class BlogUserController {

    private final BlogUserService blogUserService;

    @PostMapping("")
    public ResponseEntity<?> SaveNewUser(@RequestBody BlogUser blogUser) throws DuplicateUsernameException{
        if(blogUserService.findByUsername(blogUser.getUsername()).isPresent()){
            throw new DuplicateUsernameException("Username already used");
        }
        return ResponseEntity.ok(blogUserService.saveNewUser(blogUser));
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(blogUserService.findByUsername(username));
    }
}
