package com.liangjiange.cloud.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by liangjiange on 2017/3/13.
 */
public class HttpTest {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson)) // 加上这句话
                .build();

        HttpService service = retrofit.create(HttpService.class);

        Call<String> call = service.getResultById("12");
        try {
            Response<String> repos  = call.execute();
            System.out.println(repos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
