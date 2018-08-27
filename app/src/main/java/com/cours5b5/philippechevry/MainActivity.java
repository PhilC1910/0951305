package com.cours5b5.philippechevry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Anglais", this.getResources().getString(R.string.langue));
        Log.d("oriantation", this.getResources().getString(R.string.orientation));
        setContentView(R.layout.activity_main);
    }
}
