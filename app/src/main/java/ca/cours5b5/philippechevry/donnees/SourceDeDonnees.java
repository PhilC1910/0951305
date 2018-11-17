package ca.cours5b5.philippechevry.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void  chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);
    public abstract void  detruireSauvegarde(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected  String getNomModele(String cheminSauvegarde){

       String[] tabElementChemin =  cheminSauvegarde.split("/");

        return tabElementChemin[0] ;
    }



}
