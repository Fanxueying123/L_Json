package com.example.dell.l_json.net;

import com.example.dell.l_json.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 2018/5/11.
 */

public interface APiService {
    @GET("getNews.php")
    Call<HttpResult<List<News>>> getNews();

}
