package com.newsampath.driving.school.controller;

import com.newsampath.driving.school.dto.PostDto;
import com.newsampath.driving.school.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins="http://localhost:4200/",maxAge = 3600L)

public class PostController {
    @Autowired
    private PostService postService;

    //@CrossOrigin(origins="http://localhost:4200/")
    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto)
    {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);

    }
    //@CrossOrigin(origins="http://localhost:4200/")
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }
}