package com.nyoshcode.client;

import com.nyoshcode.post.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface JsonPlaceholderService {

    @GetMapping("/posts")
    List<Post> findAll();

    @GetMapping("/posts/{id}")
    Post findById();

    @PostMapping("/posts")
    Post create(@RequestBody Post post);

    @PutMapping("/posts/{id}")
    Post update(@PathVariable Integer id, @RequestBody Post post);

    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable Integer id);
}

