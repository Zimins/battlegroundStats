package com.zimincom.battlegroundstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class IntroActivity extends Activity {

    EditText nickNameInput;
    Button buttonSearch;
    String nickName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        buttonSearch = (Button) findViewById(R.id.button_search);
        nickNameInput = (EditText) findViewById(R.id.nickNameInput);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nickName = nickNameInput.getText().toString();
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                intent.putExtra("nickName", nickName);
                startActivity(intent);
                //Log.d("name", nicName);

            }
        });


    }
}
