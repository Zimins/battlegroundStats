package com.zimincom.battlegroundstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.os.Build;
import android.widget.ListView;

public class IntroActivity extends Activity {

    //EditText nickNameInput;
    AutoCompleteTextView nickNameInput;
    Button buttonSearch;
    String nickName = null;
    static final String[] listMenu = {"LIST1", "LIST2", "LIST3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        buttonSearch = (Button) findViewById(R.id.button_search);
        nickNameInput = (AutoCompleteTextView) findViewById(R.id.nickNameInput);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listMenu);
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
