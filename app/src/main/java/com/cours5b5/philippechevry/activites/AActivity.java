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



        Spinner spinnerHauteur = this.findViewById(R.id.hauteurNombre);
        spinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choixHauteur = (adapterView.getAdapter().getItem(i).toString());
                MParametres.instance.setHauteur(Integer.parseInt(choixHauteur));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Spinner spinnerLargeur = this.findViewById(R.id.largeurNombre);
        spinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choixLargeur= (adapterView.getAdapter().getItem(i).toString());
                MParametres.instance.setLargeur(Integer.parseInt(choixLargeur));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinnerPourGagner = this.findViewById(R.id.pourGagnerNombre);

        spinnerPourGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String choixPourGagner = (adapterView.getAdapter().getItem(i).toString());
                MParametres.instance.setPourGagner(Integer.parseInt(choixPourGagner));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if(savedInstanceState != null){
            restaurerParametres(savedInstanceState);
        }

    }
    private void restaurerParametres(Bundle savedInstanceState){

            Map<String,Object> objetJson = MParametres.instance.enObjetJson();
            String json = Jsonification.enChaine(objetJson);
        MParametres.instance.aPartirObjetJson(objetJson);

        Log.d("atelier 5:", AActivity.class.getSimpleName()+"::restaurerParametres, clé:"+ MParametres.instance.getClass().getSimpleName());
        Log.d("atelier 5:", AActivity.class.getSimpleName()+"::restaurerParametres, json:"+json);

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


        Map<String,Object> objetJson = MParametres.instance.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putString(this.getClass().getSimpleName(), json);

        Log.d("atelier 5:", AActivity.class.getSimpleName()+"::sauvegarderParametres, clé:"+ MParametres.instance.getClass().getSimpleName());

        Log.d("atelier 5:", AActivity.class.getSimpleName()+"::sauvegarderParametres, json:"+json);
    }



}
