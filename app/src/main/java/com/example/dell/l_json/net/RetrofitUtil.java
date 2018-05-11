package com.example.dell.l_json.net;

import com.example.dell.l_json.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2018/5/11.
 */

public class RetrofitUtil {
    public static void getNews(Callback<HttpResult<List<News>>> callback){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://211.67.147.26/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APiService aPiService=retrofit.create(APiService.class);
        Call<HttpResult<List<News>>> call=aPiService.getNews();
        call.enqueue(callback);
    }
}
