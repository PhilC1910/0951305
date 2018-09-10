package com.cours5b5.philippechevry.activites;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.cours5b5.philippechevry.R;
import com.cours5b5.philippechevry.modeles.MParametres;
import com.cours5b5.philippechevry.serialisation.Jsonification;

import java.util.Map;

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


        if(savedInstanceState != null){
            MParametres monModele = new MParametres();
            String json = savedInstanceState.getString(this.getClass().getSimpleName());
            Map<String,Object>objetJson = Jsonification.enObjetJson(json);
            monModele.aPartirObjetJson(objetJson);
        }
        Spinner spinnerHauteur = this.findViewById(R.id.hauteurNombre);
        spinnerHauteur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String lechoix = (String) parent.getAdapter().getItem(position);
            }


        });
        Spinner spinnerLargeur = this.findViewById(R.id.largeurNombre);
        Spinner spinnerPourGagner = this.findViewById(R.id.pourGagner);
        MParametres monModele = new MParametres();
        Map<String,Object> objetJson = monModele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        monModele.aPartirObjetJson(objetJson);
    }
    private void restaurerParametres(Bundle savedInstanceState){

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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        sauvegarderParametres(outState);



    }
    private void sauvegarderParametres(Bundle outState){
        MParametres monModele = new MParametres();
        Map<String,Object> objetJson = monModele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putInt(this.getClass().getSimpleName(), Integer.parseInt(json));
    }

}
