package com.example.dell.l_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.l_json.bean.News;
import com.example.dell.l_json.net.HttpResult;
import com.example.dell.l_json.net.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="MainActivity" ;
    private Button btnJson;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        btnJson.setOnClickListener(this);
    }

    private void initView() {
        btnJson=(Button)findViewById(R.id.btn_josn);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_josn:
                retrifit();
                break;
        }
    }

    private void retrifit() {
        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
                List<News> newsList=response.body().getData();
                for(News news:newsList){
                    Log.i(TAG,news.toString());

                }
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });

    }
}
