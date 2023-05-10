package com.global.bolgapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.bolgapp.model.Post;
import com.global.bolgapp.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    

    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<?> finAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCount(){
        return ResponseEntity.ok(postService.getCount());
    }

    @PostMapping("")
    public ResponseEntity<?> insertPost(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("")
    public ResponseEntity<?> updatePost(@RequestBody Post post){
        return ResponseEntity.ok(postService.update(post));
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deleteById(id);
    }
}
