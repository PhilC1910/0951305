package com.cours5b5.philippechevry.vues;

import android.content.Context;

import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cours5b5.philippechevry.R;
import com.cours5b5.philippechevry.activites.AActivity;
import com.cours5b5.philippechevry.activites.AMenuPrincipal;
import com.cours5b5.philippechevry.global.gConstantes;
import com.cours5b5.philippechevry.modeles.MParametres;

import java.util.Collection;

public class VParametres extends Vue {

    static {

        Log.d("atelier4",AActivity.class.getSimpleName()+":: onFinishInflate");

    }
    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


        MParametres monModele = MParametres.instance;

        Spinner spinnerHauteur = this.findViewById(R.id.hauteurNombre);

        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
        adapterHauteur.addAll( monModele.getChoixHauteur());

        spinnerHauteur.setAdapter(adapterHauteur);

        spinnerHauteur.setSelection(adapterHauteur.getPosition(MParametres.instance.getHauteur()));

        Spinner spinnerLargeur = this.findViewById(R.id.largeurNombre);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
       adapterLargeur.addAll( monModele.getChoixLargeur());

        spinnerLargeur.setAdapter(adapterLargeur);
        spinnerLargeur.setSelection(adapterLargeur.getPosition(MParametres.instance.getLargeur()));

        Spinner spinnerPourGagner = this.findViewById(R.id.pourGagnerNombre);
        ArrayAdapter<Integer> adapterPourGagner = new ArrayAdapter<>(this.getContext(),R.layout.support_simple_spinner_dropdown_item);
        adapterPourGagner.addAll( monModele.getChoixPourGagner());

        spinnerPourGagner.setAdapter(adapterPourGagner);
        spinnerPourGagner.setSelection(adapterPourGagner.getPosition(MParametres.instance.getPourGagner()));


    }




}
