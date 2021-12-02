package com.example.post_app.service.iapp;

import com.example.post_app.model.web.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getAll();

    public Post save(Post post);

    public Post delete(int id);

    public Post update(int id, Post post);

}
