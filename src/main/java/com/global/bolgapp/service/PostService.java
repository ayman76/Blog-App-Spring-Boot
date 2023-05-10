package com.global.bolgapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.bolgapp.model.Post;
import com.global.bolgapp.repository.PostRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Post findById(Long id) {
        return postRepo.findById(id).orElseThrow();
    }

    public Post getById(Long id) {
        return postRepo.getReferenceById(id);
    }

    public Long getCount() {
        return postRepo.count();
    }

    public Post save(Post post) {
        return postRepo.save(post);
    }

    public Post update(Post post) {
        Post updated = getById(post.getId());
        updated.setTitle(post.getTitle());
        updated.setBody(post.getBody());
        updated.setUser(post.getUser());
        
        return postRepo.save(post);
    }
    public void deleteById(Long id){
        postRepo.deleteById(id);
    }

}