package com.example.volley;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;

    private Handler han=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String ss=(String) msg.obj;
                    Gson gson = new Gson();

                    tv.setText(gson.fromJson(ss,MyUri.class).getData().toString());
                    Log.d("log",gson.fromJson(ss,MyUri.class).toString());
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Volley开始请求
        String str="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page=1";
        Okhttp.getData(this,str,han,0);


//        RequestQueue mStrRequest = Volley.newRequestQueue(this);
//        StringRequest stringRequestHead = new StringRequest("", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Gson gson = new Gson();
//                MyUri myUri = gson.fromJson(s, MyUri.class);
//                tv.setText(myUri.toString());
//                Log.d("log",myUri.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//
//            }
//        });
    }
}
