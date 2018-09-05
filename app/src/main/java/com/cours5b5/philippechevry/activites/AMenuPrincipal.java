package com.cours5b5.philippechevry.activites;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cours5b5.philippechevry.R;

import static java.security.AccessController.getContext;

public class AMenuPrincipal extends Activite {

    static {
        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onCreate");
        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onResume");
        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onPause");
        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onSaveInstanceState");
        Log.d("atelier4",AMenuPrincipal.class.getSimpleName()+":: onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        Button buttonParametres = this.findViewById(R.id.buttonParamettre);
        buttonParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntention  = new Intent(getApplicationContext(), AActivity.class);
                startActivity(monIntention);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }


}
