package com.global.bolgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.bolgapp.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {


}
