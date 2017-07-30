package com.zimincom.battlegroundstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

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

    Intent intent;
    String userNickName = "";
    RemoteService pubgService;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Gson gson = new Gson();

        Logger.addLogAdapter(new AndroidLogAdapter());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        pubgService = retrofit.create(RemoteService.class);
        result = (TextView) findViewById(R.id.tv_response);

        // TODO: 2017. 7. 30. 로딩바 추가하기

        intent = getIntent();

        if (intent.getExtras() != null) {
            userNickName = intent.getExtras().getString("nickName", "");
            if (!userNickName.equals("")) {
                requestStats(userNickName);
            } else {
                Logger.d("there is no name:");
            }
        } else {
            Logger.d("there is no intent");
        }
    }

    private void requestStats(String userNickName) {

        Call<UserInfo> call = pubgService.getUserInfo(userNickName);
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
                    result.setText(userInfo.toString());
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
