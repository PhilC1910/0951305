package ca.cours5b5.philippechevry.activites;

import android.os.Bundle;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurModeles;
import ca.cours5b5.philippechevry.controleurs.ControleurPartieReseau;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.modeles.MPartieReseau;

public class APartieReseau extends Activite implements Fournisseur {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause() {
        super.onPause();
          //  ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ControleurPartieReseau.getInstance().connecterAuServer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ControleurModeles.detruireModele(MPartieReseau.class.getSimpleName());
    }


}
