package com.cours5b5.philippechevry.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cours5b5.philippechevry.R;
import com.cours5b5.philippechevry.global.gConstantes;

public class vParametres extends ConstraintLayout {



    public vParametres(Context context) {
        super(context);
    }


    public vParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public vParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spinnerHauteur = this.findViewById(R.id.hauteurNombre);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
        spinnerHauteur.setAdapter(adapterHauteur);
        for(int i = gConstantes.hauteurMin ;i < gConstantes.hauteurMax ; i++){
            adapterHauteur.add(i);

        }
        spinnerHauteur.setSelection(adapterHauteur.getPosition(gConstantes.hauteurDefault));



        Spinner spinnerLargeur = this.findViewById(R.id.largeurNombre);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
        spinnerLargeur.setAdapter(adapterLargeur);
        for(int i = gConstantes.largeurMin ;i < gConstantes.largeurMax ; i++){
            adapterLargeur.add(i);

        }
        spinnerLargeur.setSelection(adapterLargeur.getPosition(gConstantes.largeurDefault));


        Spinner spinnerPourGagner = this.findViewById(R.id.pourGagnerNombre);
        ArrayAdapter<Integer> adapterPourGagner = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
        spinnerPourGagner.setAdapter(adapterPourGagner);
        for(int i = gConstantes.pourGagnerMin ;i < gConstantes.pourGagnerMax ; i++){
            adapterPourGagner.add(i);

        }
        spinnerPourGagner.setSelection(adapterPourGagner.getPosition(gConstantes.pourGagnerDefault));

    }




}
