package com.nyoshcode.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {

    private final RestClient restClient;

    public PostService(){
        restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});

    }

    public Post findById() {
        return restClient.get()
                .uri("/posts/{id}")
                .retrieve()
                .body(Post.class);
    }

    Post create(Post post){
        return restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    Post update(Integer id, Post post){
        return restClient.put()
                .uri("/posts/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    void delete(Integer id){
        restClient.delete()
                .uri("/posts/{id}",id)
                .retrieve()
                .toBodilessEntity();
    }



}
