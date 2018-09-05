package com.cours5b5.philippechevry.activites;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cours5b5.philippechevry.R;

public class AActivity extends Activite{

    static {
        Log.d("atelier4",AActivity.class.getSimpleName()+":: onCreate");
        Log.d("atelier4",AActivity.class.getSimpleName()+":: onResume");
        Log.d("atelier4",AActivity.class.getSimpleName()+":: onPause");
        Log.d("atelier4",AActivity.class.getSimpleName()+":: onSaveInstanceState");
        Log.d("atelier4",AActivity.class.getSimpleName()+":: onDestroy");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
