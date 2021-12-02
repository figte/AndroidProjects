package com.example.post_app.service.web;

import com.example.post_app.model.web.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiPostServices {
    //base url (prod): "https://jsonplaceholder.typicode.com/"

    //url relativa : "/posts"

    @GET("posts")
    Call<ArrayList<Post>> getAll();

    @GET("posts/{id}")
    Call<Post> getById(@Path("id") int id);

    @POST("posts")
    @FormUrlEncoded
    Call<Post> save(@Field("userId") int userId, @Field("title")String title,@Field("body") String body);

    @DELETE("posts/{id}")
    Call<Post> delete(@Path("id") int id);

    @PUT("posts/{id}")
    @FormUrlEncoded
    Call<Post> update(@Path("id") int id,@Field("userId") int userId, @Field("title")String title,@Field("body") String body);

}
