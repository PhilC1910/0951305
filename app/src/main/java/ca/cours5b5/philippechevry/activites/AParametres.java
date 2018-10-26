package ca.cours5b5.philippechevry.activites;

import android.os.Bundle;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurModeles;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.modeles.MParametres;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
