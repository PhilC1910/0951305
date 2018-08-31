package com.cours5b5.philippechevry.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cours5b5.philippechevry.R;

public class aActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Anglais", this.getResources().getString(R.string.langue));
        Log.d("oriantation", this.getResources().getString(R.string.orientation));


    }
}
