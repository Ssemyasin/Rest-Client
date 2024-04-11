package com.nyoshcode.post;

import com.nyoshcode.client.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceholderService postService;

    @Autowired
    public PostController(JsonPlaceholderService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable Integer id){
        return postService.findById();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @PutMapping("/{id}")
    Post update(@PathVariable Integer id, @RequestBody Post post){
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id, @RequestBody Post post){
        postService.delete(id);
    }
}
