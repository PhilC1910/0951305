package ca.cours5b5.philippechevry.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.philippechevry.controleurs.ControleurModeles;
import ca.cours5b5.philippechevry.donnees.Disque;
import ca.cours5b5.philippechevry.donnees.SauvegardeTemporaire;
import ca.cours5b5.philippechevry.donnees.Serveur;
import ca.cours5b5.philippechevry.donnees.Transition;
import ca.cours5b5.philippechevry.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                new Transition(getIntent().getExtras()),
                Serveur.getInstance(),
                Disque.getInstance());



    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));
    }

}
