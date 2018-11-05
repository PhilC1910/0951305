package ca.cours5b5.philippechevry.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.philippechevry.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        if(bundle != null && bundle.containsKey(this.getCle(cheminSauvegarde))){

            String json = bundle.getString(this.getCle(cheminSauvegarde));

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        }else{

            return null;

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(this.getCle(cheminSauvegarde), json);

        }
    }

    private String getCle(String cheminSauvegarde){
        String[] tabElementChemin =  cheminSauvegarde.split("/");
        String cle = tabElementChemin[0];
        return cle;
    }

}