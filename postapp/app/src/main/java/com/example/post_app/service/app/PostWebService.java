package com.example.post_app.service.app;

import com.example.post_app.adapter.web.ApiAdapter;
import com.example.post_app.model.web.Post;
import com.example.post_app.service.iapp.IPostService;
import com.example.post_app.service.web.ApiPostServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostWebService implements IPostService, Callback<ArrayList<Post>>{

    List<Post> data;

    @Override
    public List<Post> getAll() {
         this.data=new ArrayList<Post>();

        Call<ArrayList<Post>> call;
        // ApiPostServices apiPostServices=ApiAdapter.getApiService();
        //configurando peticion
         call= ApiAdapter.getApiService().getAll();

        //realizando peticion
        call.enqueue(this);

        return this.data;
    }


    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post delete(int id) {
        return null;
    }

    @Override
    public Post update(int id, Post post) {
        return null;
    }

    @Override
    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
        //  data=new ArrayList<>(response.body());
        for (Post item :
                response.body()) {
            Post post=new Post();
            post.setId(item.getId());
            post.setUserId(item.getUserId());
            post.setTitle(item.getTitle());
            post.setBody(item.getBody());
            this.data.add(post);
        }
        System.out.println("Status: "+response.code());
    }

    @Override
    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

    }
}
