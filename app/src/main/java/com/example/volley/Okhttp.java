package com.example.volley;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 灰太狼 on 2016/11/4.
 */
public class Okhttp {
    private static String string;

    public static void getData(Context context, String url, final Handler handler, final int i)
    {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                string = response.body().string();
                Message msg=Message.obtain();
                msg.obj=string;

                msg.what=i;
                handler.sendMessage(msg);

            }
        });
    }


}
