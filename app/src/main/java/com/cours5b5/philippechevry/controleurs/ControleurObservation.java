package com.cours5b5.philippechevry.controleurs;

import com.cours5b5.philippechevry.controleurs.interfaces.ListenerObservateur;
import com.cours5b5.philippechevry.modeles.MParametres;
import com.cours5b5.philippechevry.modeles.MParametresPartie;
import com.cours5b5.philippechevry.modeles.MPartie;
import com.cours5b5.philippechevry.modeles.Modele;

import java.util.Map;

public class ControleurObservation {
    private  static Map<Modele, ListenerObservateur> observations;
    private static MPartie partie;

    static{

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur) {
        Modele modele;
     if(nomModele == "MPartie"){
        partie = new MPartie(MParametresPartie.aPartirMParametres(MParametres.instance));
        observations.put(ControleurObservation.partie ,listenerObservateur);
        modele = ControleurObservation.partie;
     }else if(nomModele == "MParametres"){
         modele = MParametres.instance;
         observations.put(modele ,listenerObservateur);
     }





    }
}
