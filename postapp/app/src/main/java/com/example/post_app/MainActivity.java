package com.example.post_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.post_app.adapter.web.ApiAdapter;
import com.example.post_app.model.web.Post;
import com.example.post_app.service.app.PostWebService;
import com.example.post_app.service.iapp.IPostService;
import com.example.post_app.service.web.ApiPostServices;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtRespuesta;
    IPostService service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service= new PostWebService();

        txtRespuesta=(TextView) findViewById(R.id.txtRespuesta);

      /*  List<Post> items=service.getAll();
        txtRespuesta.setText(" "+items.size());*/


        //obtener por id
         Call<Post> call=ApiAdapter.getApiService().getById(100);
        //eliminar

        //Call<Post> call=ApiAdapter.getApiService().delete(100);}

        //guardar
        //Call<Post> call=ApiAdapter.getApiService().save(10,"Pureba titulo","descripcion");

        //actualizar
      // Call<Post> call=ApiAdapter.getApiService().update(10,10,"Pureba titulo","descripcion");


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                String data = "";
                Post item = response.body();
                data = data + "\n id: " + item.getId()
                        + ", userId:" + item.getUserId()
                        + ", title: " + item.getTitle()
                        + ", body: " + item.getBody()
                        + "\n";


                txtRespuesta.setText(data);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });

    }
}