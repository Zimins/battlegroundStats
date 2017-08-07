package com.zimincom.battlegroundstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;
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

    ImageView profileImage;
    TextView nicknameTextView;
    TextView result;
    EditText nickNameInput;
    ProgressBar searchProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Gson gson = new Gson();

        Logger.addLogAdapter(new AndroidLogAdapter());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        pubgService = retrofit.create(RemoteService.class);
        profileImage = (ImageView) findViewById(R.id.iv_profile);
        nicknameTextView = (TextView) findViewById(R.id.tv_nickname);
        result = (TextView) findViewById(R.id.tv_response);
        nickNameInput = (EditText) findViewById(R.id.input_nickname);
        searchProgressBar = (ProgressBar) findViewById(R.id.progress_search);

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

    private void requestStats(final String userNickName) {

        Call<UserInfo> call = pubgService.getUserInfo(userNickName);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if (response.isSuccessful()) {
                    UserInfo userInfo = response.body();
                    Logger.json(response.body().toString());
                    if (userInfo.getPlayerName() == null) {
                        Toast.makeText(MainActivity.this, "result not found", Toast.LENGTH_LONG)
                                .show();
                        nickNameInput.setText("");
                    } else {
                        LiveTracking[] liveTracking = userInfo.getLiveTracking();
                        History[] histories = userInfo.getHistories();
                        Stat[] stats = histories[0].getStats();
                        Picasso.with(MainActivity.this)
                                .load(userInfo.getAvatarImageUrl())
                                .into(profileImage);
                        nicknameTextView.setText(userInfo.getPlayerName());
                        result.setText(userInfo.toString());
                    }

                    if (searchProgressBar.getVisibility() == View.VISIBLE) {
                        searchProgressBar.setVisibility(View.INVISIBLE);
                    }


                } else {
                    Logger.d("response is not successful");
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                Log.d("main", "onFailure");
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_search) {
            searchProgressBar.setVisibility(View.VISIBLE);
            requestStats(nickNameInput.getText().toString());
        }
        return super.onOptionsItemSelected(item);
    }
}
