package com.example.post_app.adapter.web;

import com.example.post_app.service.web.ApiPostServices;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static ApiPostServices API_SERVICE;

    public static ApiPostServices getApiService() {

        if (API_SERVICE==null){
            //configuracion de retrofit para realizar peticiones a la API
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();

            //configurando recurso para peticiones a los servicios web de post de la api
            API_SERVICE= retrofit.create(ApiPostServices.class);

        }

        return API_SERVICE;
    }
}
