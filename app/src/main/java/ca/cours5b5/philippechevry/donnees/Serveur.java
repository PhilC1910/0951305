package ca.cours5b5.philippechevry.donnees;

import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import java.util.Map;

import ca.cours5b5.philippechevry.exceptions.ErreurSerialisation;

public  final class Serveur extends SourceDeDonnees {
    private static final Serveur instance = new Serveur();

    public static Serveur getInstance() {
        return instance;
    }

    private Serveur() {
    }

    @Override
    public void chargerModele(String cheminSauvegarde,final ListenerChargement listenerChargement) {
        try {

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists()){

                        Map<String, Object> objectJson = (Map<String, Object>) dataSnapshot.getValue();

                        listenerChargement.reagirSucces(objectJson);

                        //Données lues

                    } else {
                        //Pas de données dans ce noeud
                        listenerChargement.reagirErreur(new ErreurSerialisation("erreur atelier12"));
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //Erreur de lecture
                    listenerChargement.reagirErreur(databaseError.toException());
                }


            });

            //listenerChargement.reagirSucces(Jsonification.aPartirChaineJson(reference.toString()));

        } catch (Exception e){

            listenerChargement.reagirErreur(e);

        }



    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);
    }



}
