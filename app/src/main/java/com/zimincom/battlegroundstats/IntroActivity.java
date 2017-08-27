package com.zimincom.battlegroundstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class IntroActivity extends Activity {

    AutoCompleteTextView nickNameInput;
    Button buttonSearch;
    String nickName = null;

    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        buttonSearch = (Button) findViewById(R.id.button_search);
        nickNameInput = (AutoCompleteTextView) findViewById(R.id.nickNameInput);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        nickNameInput.setAdapter(adapter);

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
