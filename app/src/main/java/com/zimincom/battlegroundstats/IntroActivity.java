package com.zimincom.battlegroundstats;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IntroActivity extends Activity {

    EditText nicNameInput;
    Button buttonSearch;
    String nicName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        buttonSearch = (Button) findViewById(R.id.button_search);
        nicNameInput = (EditText) findViewById(R.id.nicNameInput);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nicName = nicNameInput.getText().toString();
                Log.d("name", nicName);
            }
        });


    }
}
