package ca.cours5b5.philippechevry.activites;

import android.os.Bundle;

import ca.cours5b5.philippechevry.R;
import ca.cours5b5.philippechevry.controleurs.ControleurAction;
import ca.cours5b5.philippechevry.controleurs.ControleurModeles;
import ca.cours5b5.philippechevry.controleurs.interfaces.Fournisseur;
import ca.cours5b5.philippechevry.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.philippechevry.global.GCommande;
import ca.cours5b5.philippechevry.modeles.MPartie;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();

                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}