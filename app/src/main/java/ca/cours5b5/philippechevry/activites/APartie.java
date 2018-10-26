package ca.cours5b5.philippechevry.activites;


import android.os.Bundle;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurModeles;
import ca.cours5b5.philippechevry.donnees.SauvegardeTemporaire;
import ca.cours5b5.philippechevry.modeles.MParametres;
import ca.cours5b5.philippechevry.modeles.MPartie;

public class APartie extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_partie);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MPartie.class.getSimpleName(),
                new SauvegardeTemporaire(outState));

    }
}