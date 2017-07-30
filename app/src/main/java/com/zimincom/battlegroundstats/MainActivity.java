package com.zimincom.battlegroundstats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zimincom.battlegroundstats.StatObjects.History;
import com.zimincom.battlegroundstats.StatObjects.LiveTracking;
import com.zimincom.battlegroundstats.StatObjects.Stat;
import com.zimincom.battlegroundstats.StatObjects.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zimincom.battlegroundstats.RemoteService.BASE_URL;

public class MainActivity extends AppCompatActivity {

    EditText nicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        nicName = (EditText) findViewById(R.id.nicName);
        
        Gson gson = new Gson();

        Logger.addLogAdapter(new AndroidLogAdapter());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RemoteService pubgService = retrofit.create(RemoteService.class);

        Call<UserInfo> call = pubgService.getUserInfo("Good_life");
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
               if (response.isSuccessful()) {
                   UserInfo userInfo = response.body();
                   Log.d("main", userInfo.toString());
                   Logger.json(response.body().toString());
                   LiveTracking[] liveTracking = userInfo.getLiveTracking();
                   History[] histories = userInfo.getHistories();
                   Stat[] stats = histories[0].getStats();
                   Logger.d(liveTracking);
                   Logger.d(histories[0]);
                   Logger.d(stats[17]);
               } else {
                   Log.d("main", "error");
               }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                Log.d("main", "onFailure");
                t.printStackTrace();
            }
        });
    }
}
